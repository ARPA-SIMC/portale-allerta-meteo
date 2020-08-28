package it.eng.sms.bean;

import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.sms.utility.SMSUtility;

public class SMSAction /*implements Callable<String>*/  {
	
	/* DELETE CLASS
	private Log _log = LogFactoryUtil.getLog(SMSAction.class);
	
	private String host;
	private int port;
	private String login;
	private String password;
	private Socket socket;
	private boolean loopS = true;
	private boolean keepalive = false; //TRN 99

//	private CounterSms smsSpeditiParziale;
	private int smsSpeditiFromLastStart;
//	private Date todayWithZeroTime;

	private Date lastCommand = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmmss");
//	private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private List<Integer> trn = new ArrayList<Integer>();
	private List<SMSBean> smsBean;

	private HashMap<String, Date> listaAttesa = new HashMap<String, Date>();

	byte[] buffer = new byte[65536];
	int writeIndex = 0;
	int parseIndex = 0;

	Random r = new Random();

	List<String> bufferedCommands = new ArrayList<String>();

	SMSUtility smsUtility = new SMSUtility();
	
	synchronized private void addToQueueAndSend(int trnOne, SMS s) {
		SMSBean invio = new SMSBean(trnOne, s);
		smsBean.add(invio);
		boolean success = acceptSMS(invio);
		if(success && invio.getDataInvio()!=null){
			_log.info("messaggio inviato -> "+invio.getSms().getId()+" "+invio.getTrn()+" dimensione trn: "+trn.size()+" dimensione smsbean: "+smsBean.size());
		}
	}

	synchronized private void putInDB(SMSBean sms, int stato, String what){
		
		sms.getSms().setStato(stato);
		
		try {
			SMSLocalServiceUtil.updateSMS(sms.getSms());
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error("Errore update", e);
			smsUtility.sendMailWithPlainText("Errore in database durante passaggio a stato "+stato+" in jvm "+ smsUtility.nameJVM()
			+ " id sms fallito "+sms.getSms().getId());
			return;
		}
		_log.info(stato+"  putindb -> "+sms.getSms().getId()+" "+sms.getTrn() + " motivo: "+what);
		smsBean.remove(sms);
		trn.add(sms.getTrn());
	}

	public SMSAction(String h, int p, String l, String pass) {
		host = h;
		port = p;
		login = l;
		password = pass;

		for (int k = 0; k < 99; k++)
			trn.add(k);

		smsBean = new ArrayList<SMSBean>();

		//gestione sms count
		smsSpeditiFromLastStart=0;

	}

	public int getSmsSpeditiFromLastStart() {
		return smsSpeditiFromLastStart;
	}

	public List<Integer> getTrn() {
		return trn;
	}

	public List<SMSBean> getSmsBean() {
		return smsBean;
	}

	@Transactional(isolation=Isolation.SERIALIZABLE)
	private void updateSmsParziale(){
//		try {
//			todayWithZeroTime = formatter.parse(formatter.format(new Date()));
//			smsSpeditiParziale = CounterSmsLocalServiceUtil.findBydata(todayWithZeroTime);
//			smsSpeditiParziale.setNumerosms(smsSpeditiParziale.getNumerosms()+1); //numero messaggi parziale
//			CounterSmsLocalServiceUtil.updateCounterSms(smsSpeditiParziale);
//		} catch (SystemException | ParseException e) {
//			// TODO Auto-generated catch block
//			logger.error(e);
//		}
//		logger.info("Conteggio SMS  "+smsSpeditiParziale.getNumerosms());
	}

	synchronized public void setLoopS(boolean loop){
		loopS = loop;
	}
	public boolean getLoopS(){
		return loopS;
	}

	public boolean isSocketConneted(){
		if(socket!= null)
			return socket.isConnected();
		else return false;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		while (loopS) {
			try {
				Thread.sleep(2000);
			} catch (Exception ex) {
			}
			try {
				_log.info("start socket");
				socket = new Socket(host, port);
				try {
					Thread.sleep(2000);
				} catch (Exception ex) {
				}
				writeCommand(commandLogin(login, password));
				try {
					Thread.sleep(2000);
				} catch (Exception ex) {
					_log.error(ex);
				}

				String loginReply = readCommand();

				if (loginReply==null) {
					_log.warn("Socket connected and LOGIN PROBLEM");
					throw new Exception("SMS Login problem");
				}

				String l2[] = dismantleCommand(loginReply);
				if (!l2[4].equals("A")) {
					_log.warn("Socket connected and LOGIN PROBLEM");
					throw new Exception("SMS Login problem");
				}
				_log.info("Socket connected and login completed");
				smsUtility.sendMailWithPlainText("Socket connected and login completed "+ smsUtility.nameJVM());
				try {
					while (loopS) {
						long timeToSleep = 3000;

						//controllo se vi sono ack negli ultimi n minuti
						if(new Date().getTime() - lastCommand.getTime() > 5 * 60 *1000 ){
							smsUtility.sendMailWithPlainText("Non vi sono stati keep alive negli ultimi 5 minuti "+ smsUtility.nameJVM()+
									"Ultimo invio "+lastCommand.toString());
							socket.close();
							lastCommand = new Date();
							keepalive=false;
							break;
						}

						try {
							if(trn.size()>0){
//								logger.info("siamo prima della lettura da db dimensione trn: "+trn.size()+" dimensione smsbean: "+smsBean.size());
								List<Object[]> smsFromDB = SMSLocalServiceUtil.ottieniPerSpedizione(null, null, 0, 1, 2, trn.size()>30?30:trn.size());//il 7 era un 2
								if (smsFromDB.size() > 0) {
									_log.info("smsLoop -> ottieniPerSpedizione. Trovati " + smsFromDB.size() + " SMS");
									timeToSleep = 3000;
								}

								for (Object[] o : smsFromDB) {
									SMS theSMS = SMSLocalServiceUtil.fetchSMS(Long.parseLong(o[3].toString()));
									_log.info("recupero sms -> " +theSMS.getId());
									if (theSMS != null){
										addToQueueAndSend(trn.remove(0), theSMS);
									}
								}
							}
						} catch (Exception e3) {
							_log.error("smsLoopError -> ottieniPerSpedizione " + e3.getMessage());
						}

						while (bufferedCommands.size() > 0) {
							receiveCommand(bufferedCommands.remove(0),false);
						}

						receiveCommand(readCommand(),false);

						if (new Date().getTime() - lastCommand.getTime() > 30000 && !keepalive) {
							keepalive = true;
							writeCommand(makeCommand(99, "O", 31, login.concat("/0100")));
							//							lastKeepAlive = new Date();
							_log.info("Elementi presenti nel vettore trn: "+String.valueOf(trn.size()));

						}
						purgeMissingAckSMS();

						if (listaAttesa.size()>0) {
							List<String> comandi = new ArrayList<String>();
							for (String sss : listaAttesa.keySet()) {
								Date d = listaAttesa.get(sss);
								if (d!=null && d.before(new Date()))
									comandi.add(sss);
							}
							for (String sss : comandi) {
								listaAttesa.remove(sss);
								receiveCommand(sss,true);
							}
						}
						try {
							Thread.sleep(timeToSleep + r.nextInt(500));
						} catch (Exception ex) {
							_log.error(ex.getMessage(),ex);
						}

					}
				} catch (Exception inn) {
					smsUtility.sendMailWithPlainText(smsUtility.nameJVM()+" Error SMSThread.run innerLoop " +  inn.getMessage());
					_log.error("SMSThread.run innerLoop " + inn.getMessage());
				}

			} catch (Exception e) {

				_log.error("SMSThread.run outerLoop", e);

				// rimettiamoli in circolo
				rimettiamoliInCircolo(new ArrayList<SMSBean>(smsBean));
				
				_log.info("Sono nel catch dell'outerLoop, il numero di sms nel bean è: "+smsBean.size()
				+" la dimensione del vettore trn è: "+trn.size());
				smsBean.clear();

				try {
					if (socket != null && !socket.isClosed())
						socket.close();
					Thread.sleep(30000);
				} catch (Exception ex) {
					_log.error(ex.getMessage(),ex);
				}
			}
		}

		socket.close();
		socket = null;
		// rimettiamoli in circolo
//		try{
//			for (SmsBean sms : smsBean) {
//				putInDB(sms, 1, "line 277 rimettiamoli in circolo");
//			}
//		}
//		catch(RuntimeException e){
//			logger.error(e);
//		}
		rimettiamoliInCircolo(new ArrayList<SMSBean>(smsBean));
		_log.info("Sto terminando il thread, il numero di sms nel bean è: "+smsBean.size()
		+" la dimensione del vettore trn è: "+trn.size());
		_log.warn("Thread terminato");
		smsUtility.sendMailWithPlainText("Thread di gestione del socket terminato "+ smsUtility.nameJVM());
		return "Thread pool interrotto";
	}

	// rimettiamoli in circolo
	private void rimettiamoliInCircolo(final ArrayList<SMSBean> smsbeanCopy){
		try{
			for (SMSBean sms : smsbeanCopy) {
				putInDB(sms, 1, "line 294 rimettiamoli in circolo");
			}
		}catch(RuntimeException e){
			_log.error(e);
		}
	}

	private String[] dismantleCommand(String s) {
		return s.split("/");
	}

	public Date timestampToDate(String timestamp) {
		try {
			return sdf.parse(timestamp);
		} catch (Exception e) {
			_log.error("smsRead -> timestampToDate:" + timestamp + " "  + e.getMessage());
			return null;

		}

	}

	private void writeCommand(String cmd) throws Exception {
		lastCommand = new Date();
		socket.getOutputStream().write(2);
		socket.getOutputStream().write(cmd.getBytes());
		socket.getOutputStream().write(3);
		socket.getOutputStream().flush();
		_log.info("smsWrite "+ host +" "+ cmd);
		Thread.sleep(25);
	}

	private boolean acceptSMS(SMSBean s){
		//non utilizzata *start
		try {
			AllertaParametro bp = AllertaParametroLocalServiceUtil.fetchAllertaParametro("SMS_BLACKLIST");
			if (bp != null) {
				String black = bp.getValore();
				if (black != null && !black.equals("") && black.contains(s.getSms().getTipo())) {
					s.getSms().setDescrizioneErrore("Invio fittizio, tipo messaggio in blacklist.");
					putInDB(s, 4, "line 327 blacklist");
					return false;
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage(),e);
		}
		//*end

		//destinatari non numerici
		if (!isNumeric(pulisciNumero(s.getSms().getNumero()))) {
			//			s.getSms().setStato(4);
			s.getSms().setDescrizioneErrore("Non inviato, numero non numerico.");
			putInDB(s, 4, "line 338 numero non numerico.");
			return false;
		}
		try {
			writeCommand(commandSendSMS(s.getTrn(), s.getSms().getNumeroDa(), pulisciNumero(s.getSms().getNumero()), s.getSms().getTesto()));
			s.setDataInvio(new Date());
		} catch (Exception e) {
			_log.error("Errore invio sms metodo writeCommand",e);
			putInDB(s, 1, "line 346 Errore invio sms metodo writeCommand");
			return false;
		}
		updateSmsParziale();
		smsSpeditiFromLastStart++;
		return true;
	}

	private void purgeMissingAckSMS() {
		List<SMSBean> purge = new ArrayList<SMSBean>();
		for(int i=0; i< smsBean.size(); i++){
			if (new Date().getTime() - smsBean.get(i).getDataInvio().getTime() > 60000) {
				purge.add(smsBean.get(i));
			}
		}
		for(SMSBean p : purge){
			putInDB(p, 1, "line 364 purge");
		}
	}

	private String readCommand() throws Exception {

		if (bufferedCommands.size() > 0) {
			return bufferedCommands.remove(0);
		}

		while (true) {
			if (socket.getInputStream().available() > 0) {
				int read = socket.getInputStream().read(buffer, writeIndex, buffer.length - writeIndex);
				if (read == -1)
					throw new IOException("EOF nel socket");
				writeIndex += read;
				int start = -1;
				for (int k = parseIndex; k < writeIndex; k++) {
					if (buffer[k] == 2)
						start = k + 1;
					if (buffer[k] == 3) {
						String command = new String(buffer, start, k - start);
						bufferedCommands.add(command);
						_log.info("smsRead "+host+" "+command);
						parseIndex = k + 1;
					}
				}

				if (parseIndex > 0) {
					for (int k = 0; k < writeIndex - parseIndex; k++) {
						buffer[k] = buffer[parseIndex + k];
					}
					writeIndex -= parseIndex;
					parseIndex = 0;
				}
				if (bufferedCommands.size() > 0) {
					return bufferedCommands.remove(0);
				}
			} else
				return null;
		}
	}

	public void receiveCommand(String cmd, boolean lista) throws Exception {

		if (cmd == null)
			return;

		try {
			String[] s = dismantleCommand(cmd);

			int t = Integer.parseInt(s[0]);
			SMSBean sm = null;

			for(SMSBean find:smsBean){
				if(find.getTrn()==t){
					sm = find;
					break;
				}
			}
			if (s[3].equals("31")) {
				keepalive = false;
				return;
			}

			if (s[3].equals("51")) { //invio sms
				if (s[4].equals("A")) {
					if (sm != null) {
						String identifier = s[6];
						String[] idd = identifier.split(":");
						sm.getSms().setDataInvio(sm.getDataInvio());
						sm.getSms().setDataAck(timestampToDate(idd[1]));
						sm.getSms().setTimestamp(identifier);
						_log.info("51 A "+sm.getSms().getId()+" "+sm.getTrn());
						putInDB(sm, 3, "line 442 inviato con successo");
					}
					return;
				} else {
					if (sm != null) {
						_log.info("51 not A "+sm.getSms().getId()+" "+sm.getTrn());
						if (sm.getSms().getTentativi() < 3) {
							sm.getSms().setTentativi(sm.getSms().getTentativi() + 1);
							sm.getSms().setProssimoInvio(new Date(new Date().getTime() + 30000));
							putInDB(sm, 1, "line 451 set prossimo invio");
						} else {
							sm.getSms().setCodiceErrore("Numero tentativi superato");
							putInDB(sm, 5, "line 454 numero tentativi superato");
						}

					}
				}
				return;
			}

			if (s[3].equals("52")) { //ricezione sms
				int tr = Integer.parseInt(s[0]);
				String sender = s[5];
				String recipient = s[4];
				String timestamp = s[18];
				String msg = s[24];

				writeCommand(makeCommand(tr, "R", 52, "A//".concat(recipient).concat(":").concat(sdf.format(new Date()))));

				try {

					long id = CounterLocalServiceUtil.increment(SMS.class.getName());

					SMS ms = SMSLocalServiceUtil.createSMS(id);
					ms.setDestinatario(0);
					ms.setNumero(recipient);
					ms.setParam(0);
					ms.setSottotipo("inbox");
					ms.setStato(4);
					ms.setTesto(fromCommandString(msg));
					ms.setTipo("inbox");
					ms.setNumeroDa(sender);
					ms.setNomeDestinatario(null);
					ms.setDataInvio(timestampToDate(timestamp));
					ms.setDataAck(new Date());
					ms.setDataRicevuta(new Date());
					ms.setTentativi(0);
					SMSLocalServiceUtil.updateSMS(ms);

				} catch (Exception exc) {
					_log.error("receiveSMSCommand op52 " + exc);
				}
			}

			if (s[3].equals("53")) { //ricevuta

				int tr = Integer.parseInt(s[0]);
				String sender = s[4];
				String recipient = s[5];
				String timestamp = s[18];
				int status = Integer.parseInt(s[19]);
				String code = s[20];
				String newTimestamp = s[21];

				// rispondiamo con un ACK se questo non proviene dalla lista d'attesa
				if (!lista) writeCommand(makeCommand(tr, "R", 53, "A//" + sender + ":" + sdf.format(new Date())));

				Date d2 = timestampToDate(newTimestamp);
				List<SMS> l = SMSLocalServiceUtil.findByTimestamp(recipient+":"+timestamp);

				if (l != null) {
					if (l.size()==0) {
						//è possibile che abbiamo ricevuto il 53 prima del 51 in quanto il 51 è stato mandato
						//ad un altro thread che non l'ha ancora processato. In questo caso mettiamo in una
						//lista d'attesa il 53 a meno che giè non provenga dalla lista d'attesa
						if (!lista)
							listaAttesa.put(cmd, new Date(new Date().getTime() + 20000));
					}

					for (SMS ss : l) {
						if (status == 0) {
							String msg = s[24];
							ss.setDataRicevuta(d2);
							ss.setStato(4);
							try {
								if (msg != null && !msg.equals(""))
									ss.setDescrizioneErrore(fromCommandString(msg));
							} catch (Exception e) {
								_log.error(e.getMessage(),e);
							}
							SMSLocalServiceUtil.updateSMS(ss);
						}
						if (status == 2) {
							ss.setStato(5);
							ss.setCodiceErrore(code);

							AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("SMS_ERRORE_" + code);
							if (ap != null)
								ss.setDescrizioneErrore(ap.getValore());
							SMSLocalServiceUtil.updateSMS(ss);

							if (ss.getTentativi() < 3 && ss.getDataInvio()!=null && (new Date().getTime()-ss.getDataInvio().getTime()<(12*60*60*1000))) {

								long id = CounterLocalServiceUtil.increment(SMS.class.getName());

								SMS nuovo = SMSLocalServiceUtil.createSMS(id);
								nuovo.setDestinatario(ss.getDestinatario());
								nuovo.setNumero(ss.getNumero());
								nuovo.setParam(ss.getParam());
								nuovo.setSottotipo(ss.getSottotipo());
								nuovo.setStato(1);
								nuovo.setTesto(ss.getTesto());
								nuovo.setTipo(ss.getTipo());
								nuovo.setNumeroDa(ss.getNumeroDa());
								nuovo.setNomeDestinatario(ss.getNomeDestinatario());
								nuovo.setDataInvio(new Date());
								nuovo.setProssimoInvio(new Date(new Date().getTime() + 300000));
								nuovo.setTentativi(ss.getTentativi() + 1);

								SMSLocalServiceUtil.updateSMS(nuovo);
							}
						}
					}
				}
				return;
			}
		} catch (Exception e) {
			_log.error("receiveSMScommand "+ host+" "+e);
		}
	}

	private String commandLogin(String login, String password) {
		return makeCommand(0, "O", 60, login + "/2/1/1/" + commandString(password) + "//0100/////");
	}

	private String pulisciNumero(String s) {
		if (s==null) return null;
		s =s.replace(" ", "");
		s = s.replace("+39", "");
		s = s.replace("0039", "");

		return s;
	}
	
	private boolean isNumeric(String s) {
		for (int k = 0; k < s.length(); k++) {
			char c = s.charAt(k);
			if (c < '0' || c > '9')
				return false;
		}
		return true;
	}
	
	private String commandSendSMS(int trn, String from, String to, String text) {

		boolean numeric = isNumeric(from);
		String otoa = (numeric ? "" : "5039");
		String realFrom = (numeric ? from : gsmString(from));
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(to).append("/").append(realFrom).append("//1///////////////3//");
		stringbuilder.append(commandString(text)).append("////////").append(otoa).append("////");
//		return makeCommand(trn, "O", 51,
//				to + "/" + realFrom + "//1///////////////3//" + commandString(text) + "////////" + otoa + "////"); cambiato in data 18/09/18
		return makeCommand(trn, "O", 51, stringbuilder.toString());

	}
	private String makeCommand(int trn, String optype, int op, String message) {

		int len = message.length() + 17;
		String l2 = "" + len;
		while (l2.length() < 5)
			l2 = "0" + l2;

		StringBuilder out = new StringBuilder();
		if (trn < 10)
			out.append("0");
		out.append(trn);
		out.append("/").append(l2).append("/");
		out.append(optype).append("/").append(op).append("/");
		out.append(message).append("/");

		int checksum = 0;
		for (int k = 0; k < out.length(); k++) {
			checksum += out.charAt(k);
		}
		checksum = checksum & 0xFF;
		out.append(hexArray[checksum >>> 4]);
		out.append(hexArray[checksum & 0x0F]);

		// LogInternoLocalServiceUtil.log("makeCommandSMS", "op" + op, out, "");

		return out.toString();
	}
	private String fromCommandString(String in) {
		// String out = "";
		byte[] out = new byte[in.length() / 2];

		for (int k = 0; k < in.length() / 2; k++) {
			int c = in.charAt(k * 2);
			int d = in.charAt(k * 2 + 1);
			int ch = 0;
			if (c >= 48 && c <= 57)
				ch = c - 48;
			else
				ch = c -= 55;

			ch = ch << 4;
			if (d >= 48 && d <= 57)
				ch += d - 48;
			else
				ch += d -= 55;

			out[k] = (byte) (ch & 0x7F);
		}

		return new String(out);
	}
	private String commandString(String in) {
		StringBuilder out = new StringBuilder();

		for (int k = 0; k < in.length(); k++) {
			try {
				int c = in.charAt(k);
				if (c==8217) c = 39; //apostrofo tipografico
				if (c<0 || c>=gsmAlphabet.length) {
					c = 32; //altri caratteri unicode che al momento trasformiamo in spazi
				}

				c = gsmAlphabet[c];
				c = c & 0x7F;
				out.append(hexArray[c >>> 4]);
				out.append(hexArray[c & 0x0F]);

			} catch (Exception e) {

			}
		}

		return out.toString();
	}
	private String gsmString(String in) {

		String binary = "";
		String out = "";

		for (int k = 0; k < in.length(); k++) {
			int c = in.charAt(k);
			c = gsmAlphabet[c];
			c = c & 0x7F;
			StringBuilder by = new StringBuilder();
			if ((c & 0x40) != 0)
				by.append("1");
			else
				by.append("0");
			if ((c & 0x20) != 0)
				by.append("1");
			else
				by.append("0");
			if ((c & 0x10) != 0)
				by.append("1");
			else
				by.append("0");
			if ((c & 0x08) != 0)
				by.append("1");
			else
				by.append("0");
			if ((c & 0x04) != 0)
				by.append("1");
			else
				by.append("0");
			if ((c & 0x02) != 0)
				by.append("1");
			else
				by.append("0");
			if ((c & 0x01) != 0)
				by.append("1");
			else
				by.append("0");
			binary = by.toString() + binary;
		}

		while ((binary.length() % 8) != 0)
			binary = "0" + binary;
		int size = binary.length() / 8;

		int mySize = binary.length() / 4;
		out += hexArray[mySize >>> 4];
		out += hexArray[mySize & 0x0F];
		// out += Character.toString((char)(size/4));

		for (int k = size - 1; k >= 0; k--) {
			int index = k * 8;
			int val = 0;
			if (binary.charAt(index) == '1')
				val += 0x80;
			if (binary.charAt(index + 1) == '1')
				val += 0x40;
			if (binary.charAt(index + 2) == '1')
				val += 0x20;
			if (binary.charAt(index + 3) == '1')
				val += 0x10;
			if (binary.charAt(index + 4) == '1')
				val += 0x08;
			if (binary.charAt(index + 5) == '1')
				val += 0x04;
			if (binary.charAt(index + 6) == '1')
				val += 0x02;
			if (binary.charAt(index + 7) == '1')
				val += 0x01;

			out += hexArray[val >>> 4];
			out += hexArray[val & 0x0F];
		}
		return out;
	}
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	final protected static byte[] gsmAlphabet = {
			0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
			0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
			0x20,0x21,0x22,0x23,0x02,0x25,0x26,0x27,0x28,0x29,0x2A,0x2B,0x2C,0x2D,0x2E,0x2F,
			0x30,0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x39,0x3A,0x3B,0x3C,0x3D,0x3E,0x3F,
			0x00,0x41,0x42,0x43,0x44,0x45,0x46,0x47,0x48,0x49,0x4A,0x4B,0x4C,0x4D,0x4E,0x4F,
			0x50,0x51,0x52,0x53,0x54,0x55,0x56,0x57,0x58,0x59,0x5A,0x28,0x2F,0x29,0x3F,0x11,
			0x27,0x61,0x62,0x63,0x64,0x65,0x66,0x67,0x68,0x69,0x6A,0x6B,0x6C,0x6D,0x6E,0x6F,
			0x70,0x71,0x72,0x73,0x74,0x75,0x76,0x77,0x78,0x79,0x7A,0x28,0x2F,0x29,0x7E,0x7F,
			0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
			0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
			0x3F,0x40,0x3F,0x01,0x24,0x03,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,
			0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x3F,0x60,
			0x41,0x41,0x41,0x41,0x5B,0x41,0x1C,0x09,0x1F,0x1F,0x45,0x45,0x49,0x49,0x49,0x49,
			0x44,0x4E,0x4F,0x4F,0x4F,0x4F,0x5C,0x78,0x4F,0x55,0x55,0x55,0x5E,0x59,0x3F,0x3F,
			0x7F,0x7F,0x61,0x61,0x7B,0x0F,0x1D,0x09,0x04,0x05,0x65,0x65,0x07,0x07,0x69,0x69,
			0x3F,0x7D,0x08,0x08,0x6F,0x6F,0x7C,0x3F,0x0C,0x06,0x06,0x75,0x7E,0x79,0x3F,0x79,
	};
	*/
}
