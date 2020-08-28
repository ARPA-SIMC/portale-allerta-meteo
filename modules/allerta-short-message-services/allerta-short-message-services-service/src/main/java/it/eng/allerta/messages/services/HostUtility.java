package it.eng.allerta.messages.services;

import com.liferay.portal.kernel.cluster.ClusterExecutorUtil;
import com.liferay.portal.kernel.cluster.ClusterNode;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.net.InetAddress;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

public class HostUtility {
	
	private static Log logger = LogFactoryUtil.getLog(HostUtility.class);
	
	private static String errMsgClusterNode = "Non è stato possibile recuperare le informazioni sul nodo locale del Cluster"; 
	private static ClusterNode clusterNode;
	private static String redirectPort = "undefined";
	
	static {
		// recupera il clusterNode
		try {
			clusterNode = ClusterExecutorUtil.getLocalClusterNode();
		} catch (SystemException e) {
			logger.error(errMsgClusterNode, e);
		}
		// ricerca la redirectPort del Tomcat
		try {
			MBeanServer mBeanServer = MBeanServerFactory.findMBeanServer(null).get(0);
			ObjectName name = new ObjectName("Catalina", "type", "Server");
			//Server server = (Server) mBeanServer.getAttribute(name, "managedResource");	
			Object server = mBeanServer.getAttribute(name, "managedResource");	
			Object[] services = (Object[])server.getClass().getMethod("findServices").invoke(server);
	        //Service[] services = server.findServices();
	        
	        for (Object service : services) {
	        	Object[] connectors = (Object[]) service.getClass().getMethod("findConnectors").invoke(service);
	            for (Object connector : connectors) {
	                Object protocolHandler = connector.getClass().getMethod("getProtocolHandler").invoke(connector);
	                String cl = protocolHandler.getClass().getName();
	                if (cl.contains("Http11Protocol") ||
	                	cl.contains("Http11AprProtocol")  ||
	                	cl.contains("Http11NioProtocol") ) 
	                {                    
	                    //Object _redirectPort = connector.getClass().getMethod("getAttribute", String.class).invoke(connector,"redirectPort");
	                	Object _redirectPort = connector.getClass().getMethod("getAttribute", String.class).invoke(connector,"port");
	                    
	                    if (_redirectPort != null) {
	                    	redirectPort = _redirectPort.toString();
	                    }	                    
	                    logger.info("Service Name = " + service.toString() + " -> HTTP redirectPort : " + redirectPort);
	                }
	            }
	        }
		} catch (Throwable t) {
			logger.error("Non è stato possibile recuperare la redirectPort del server Tomcat con seguente ip " + clusterNode.getPortalInetAddress().getHostAddress(), t);
		}
	}
	
	public static String getCurrentHostIp() throws SystemException {		
		String out = "";
		
		if (clusterNode == null) {
			InetAddress sss = PortalUtil.getPortalLocalInetAddress(true);
			
			if (sss == null) {
				sss = PortalUtil.getPortalLocalInetAddress(false);
			} 
			if (sss != null) {
				out = sss.toString();
			} else {
				out = "127.0.0.1";
			}
			//return PortalUtil.getPortalLocalInetAddress(true).toString();
			//throw new SystemException(errMsgClusterNode + " : hostIp");
		} else {
			if (clusterNode.getPortalInetAddress() != null) {
				out = clusterNode.getPortalInetAddress().getHostAddress();
			} else if (clusterNode.getBindInetAddress() != null) {
				out = clusterNode.getBindInetAddress().getHostAddress();
			} else {
				out = "127.0.0.1";
			}
		}		
		if (out != null) {
			out = out.replaceAll("/", "");
		}
		
		return out;
	}
	
	public static String getCurrentHostPort() throws SystemException {
		if (clusterNode == null) {
			int p = PortalUtil.getPortalLocalPort(true);
			
			if (p<0) {
				p = PortalUtil.getPortalLocalPort(false);
			}
			if (p<0) {
				p = 8080;
			}
			
			redirectPort = String.valueOf(p);
			//throw new SystemException(errMsgClusterNode + " : hostPort");
		}		
		
		return redirectPort;
	}
	
	public static String getCurrentHostIpAndPort() throws SystemException {
		return getCurrentHostIp() + ":" + getCurrentHostPort();
		
		/*if (clusterNode == null) {
			return getCurrentHostIp()+":"+getCurrentHostPort();
			//throw new SystemException(errMsgClusterNode + " : hostIpAndPort");
		}
		
		return clusterNode.getPortalInetAddress().getHostAddress().replaceAll("/", "") + ":" + redirectPort;*/
	}
	
	public static String getCurrentClusterId() throws SystemException {
		if (clusterNode == null) {
			return "*";
			//throw new SystemException(errMsgClusterNode + " : clusterId");
		}
		
		return clusterNode.getClusterNodeId();
	}
}
