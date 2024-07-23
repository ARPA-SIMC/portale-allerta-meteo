
--
-- TOC entry 609 (class 1259 OID 8626064)
-- Name: appartenenza_comuni_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.appartenenza_comuni_vw AS
 SELECT g.groupid,
    g.name,
    u.userid,
    u.lastname,
    u.firstname,
    u.emailaddress,
    string_agg((p.number_)::text, ','::text) AS telefoni
   FROM ((((public.group_ g
     JOIN public.users_groups ug ON ((ug.groupid = g.groupid)))
     JOIN public.user_ u ON ((ug.userid = u.userid)))
     JOIN public.contact_ c ON ((c.classpk = u.userid)))
     LEFT JOIN public.phone p ON ((p.classpk = c.contactid)))
  WHERE (g.site AND (g.groupid <> 20181) AND (NOT (EXISTS ( SELECT ur.userid,
            ur.groupid,
            ur.roleid,
            ur.mvccversion,
            ur.companyid
           FROM public.usergrouprole ur
          WHERE ((ur.userid = u.userid) AND (ur.roleid = ANY (ARRAY[(29574)::bigint, (75902)::bigint, (75920)::bigint, (451351)::bigint])))))))
  GROUP BY g.groupid, g.name, u.userid, u.lastname, u.firstname, u.emailaddress
  ORDER BY g.name, u.lastname, u.firstname;

--
-- TOC entry 289 (class 1259 OID 692442)
-- Name: comune_superamento_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.comune_superamento_vw AS
 SELECT a.allarmeid,
    ra.id_ AS idregola,
    a.colore,
    o.organizationid AS org,
    g.name AS comune,
    uo.userid,
    rac.idstazione,
    a.createdate AS datainizio,
    a.datafine,
    COALESCE(idr.nomerubrica, pluv.nomerubrica) AS rubrica
   FROM ((((((((public.bollettino_allarme a
     JOIN public.bollettino_regolaallarme ra ON ((ra.id_ = a.idregola)))
     JOIN public.bollettino_regolaallarmecondizione rac ON ((rac.idregola = a.idregola)))
     LEFT JOIN public.bollettino_idrometro idr ON ((((idr.stazioneid)::text = (rac.idstazione)::text) AND ((rac.idvariabile)::text ~~ '%B13215%'::text))))
     LEFT JOIN public.bollettino_pluviometro pluv ON ((((pluv.stazioneid)::text = (rac.idstazione)::text) AND ((rac.idvariabile)::text ~~ '%B13011%'::text))))
     JOIN public.organization_ o ON (((COALESCE(idr.nomerubrica, pluv.nomerubrica))::text = (o.name)::text)))
     JOIN public.users_orgs uo ON ((uo.organizationid = o.organizationid)))
     JOIN public.usergrouprole ugr ON ((ugr.userid = uo.userid)))
     JOIN public.group_ g ON ((g.groupid = ugr.groupid)))
  WHERE ((a.stato = 0) AND (ugr.roleid = 451351))
  ORDER BY a.allarmeid, g.name;


--
-- TOC entry 619 (class 1259 OID 39480793)
-- Name: comuni_sensori2_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.comuni_sensori2_vw AS
 SELECT (regexp_matches((rg.nome)::text, 'Comune (.*)\((.*)\)'::text))[1] AS comune,
    (regexp_matches((rg.nome)::text, 'Comune (.*)\((.*)\)'::text))[2] AS provincia,
    string_agg((replace((rg2.nome)::text, 'IDR. '::text, ''::text) ||
        CASE
            WHEN ((rg2.nome)::text !~~ '%(%'::text) THEN replace(((' ('::text || (
            CASE
                WHEN ((i.nomesottobacino IS NOT NULL) AND ((i.nomesottobacino)::text <> ''::text)) THEN i.nomesottobacino
                ELSE rgp.nome
            END)::text) || ')'::text), 'FIUME '::text, ''::text)
            ELSE ''::text
        END), ', '::text ORDER BY rg2.nome) AS idrometri,
    string_agg(replace((rg3.nome)::text, 'PLV. '::text, ''::text), ', '::text ORDER BY rg3.nome) AS pluviometri
   FROM (((((((((public.rubrica_rubricagruppo rg
     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_figlio = rg.id_gruppo)))
     LEFT JOIN public.rubrica_rubricagruppo rg2 ON (((rg2.id_gruppo = rgg.fk_gruppo_padre) AND ((rg2.nome)::text ~~ 'IDR.%'::text))))
     LEFT JOIN public.rubrica_rubricagruppo rg3 ON (((rg3.id_gruppo = rgg.fk_gruppo_padre) AND ((rg3.nome)::text ~~ 'PLV.%'::text))))
     LEFT JOIN public.bollettino_idrometro i ON (((i.nomerubrica)::text = (rg2.nome)::text)))
     LEFT JOIN public.bollettino_pluviometro p ON (((p.nomerubrica)::text = (rg3.nome)::text)))
     LEFT JOIN public.bollettino_stazione st1 ON (((st1.id_)::text = (i.stazioneid)::text)))
     LEFT JOIN public.bollettino_stazione st2 ON (((st2.id_)::text = (p.stazioneid)::text)))
     LEFT JOIN public.rubrica_rubricagruppogruppi rgg2 ON ((rgg2.fk_gruppo_figlio = rg2.id_gruppo)))
     LEFT JOIN public.rubrica_rubricagruppo rgp ON ((rgp.id_gruppo = rgg2.fk_gruppo_padre)))
  WHERE (((rg.nome)::text ~~ 'Comune%'::text) AND (st1.attivo OR st2.attivo))
  GROUP BY rg.nome
  ORDER BY rg.nome;


--
-- TOC entry 611 (class 1259 OID 8626114)
-- Name: comuni_sensori_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.comuni_sensori_vw AS
 SELECT (regexp_matches((rg.nome)::text, 'Comune (.*)\((.*)\)'::text))[1] AS comune,
    (regexp_matches((rg.nome)::text, 'Comune (.*)\((.*)\)'::text))[2] AS provincia,
    string_agg((replace((rg2.nome)::text, 'IDR. '::text, ''::text) ||
        CASE
            WHEN ((rg2.nome)::text !~~ '%(%'::text) THEN replace(((' ('::text || (bs.namesubbasin)::text) || ')'::text), 'FIUME '::text, ''::text)
            ELSE ''::text
        END), ', '::text ORDER BY rg2.nome) AS idrometri,
    string_agg(replace((rg3.nome)::text, 'PLV. '::text, ''::text), ', '::text ORDER BY rg3.nome) AS pluviometri
   FROM (((((((public.rubrica_rubricagruppo rg
     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_figlio = rg.id_gruppo)))
     LEFT JOIN public.rubrica_rubricagruppo rg2 ON (((rg2.id_gruppo = rgg.fk_gruppo_padre) AND ((rg2.nome)::text ~~ 'IDR.%'::text))))
     LEFT JOIN public.rubrica_rubricagruppo rg3 ON (((rg3.id_gruppo = rgg.fk_gruppo_padre) AND ((rg3.nome)::text ~~ 'PLV.%'::text))))
     LEFT JOIN public.bollettino_idrometro i ON (((i.nomerubrica)::text = (rg2.nome)::text)))
     LEFT JOIN public.bollettino_stazione bs ON (((bs.id_)::text = (i.stazioneid)::text)))
     LEFT JOIN public.bollettino_pluviometro p ON (((p.nomerubrica)::text = (rg3.nome)::text)))
     LEFT JOIN public.bollettino_stazione st2 ON (((st2.id_)::text = (p.stazioneid)::text)))
  WHERE (((rg.nome)::text ~~ 'Comune%'::text) AND (bs.attivo OR st2.attivo))
  GROUP BY rg.nome
  ORDER BY rg.nome;


--
-- TOC entry 630 (class 1259 OID 65203534)
-- Name: dewetra1_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.dewetra1_vw AS
 SELECT d.id_,
    d.comune,
    d."timestamp",
    d.hri,
    d.ssi,
    d.sri,
    d.vmi,
    d.vil,
    d.poh,
    d.etm,
    d.top,
    d.lgt,
    d.pers,
    d.srt,
    d.srt_3,
    d.srt_6,
    d.vel,
    d.dir,
    dc.id AS indice_colore,
    dc.colore AS ind,
    c.area,
    c.provincia
   FROM ((public.dewetra_hrw d
     JOIN public.dewetra_colori dc ON (((GREATEST(d.hri, d.ssi) >= (dc.min)::double precision) AND (GREATEST(d.hri, d.ssi) < (dc.max)::double precision))))
     JOIN public.storico_aree c ON ((((c.nome)::text = upper((d.comune)::text)) AND (c.data_inizio <= d."timestamp") AND (c.data_fine >= d."timestamp") AND ((c.tipo)::text = 'M'::text))));


--
-- TOC entry 631 (class 1259 OID 65205395)
-- Name: dewetra2_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.dewetra2_vw AS
 SELECT d.id_,
    d.comune,
    d."timestamp",
    d.hri,
    d.ssi,
    d.sri,
    d.vmi,
    d.vil,
    d.poh,
    d.etm,
    d.top,
    d.lgt,
    d.pers,
    d.srt,
    d.srt_3,
    d.srt_6,
    d.vel,
    d.dir,
    d.indice_colore,
    d.ind,
    d.area,
    d.provincia,
    a.allertaid
   FROM (public.dewetra1_vw d
     JOIN public.allerter_allerta a ON (((a.datainizio <= d."timestamp") AND (a.datafine > d."timestamp") AND (a.stato = 0))));


--
-- TOC entry 632 (class 1259 OID 65205932)
-- Name: dewetra3_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.dewetra3_vw AS
 SELECT y.allertaid,
    y.dt,
    y.area,
    ((((((y.cnt || ' record da '::text) || (y.mn)::time without time zone) || ' a '::text) || (y.mx)::time without time zone) || ', max '::text) || (y.colore)::text) AS txt
   FROM ( SELECT x.dt,
            x.allertaid,
            x.area,
            x.cnt,
            x.mn,
            x.mx,
            x.col,
            c.colore
           FROM (( SELECT date(dewetra2_vw."timestamp") AS dt,
                    dewetra2_vw.allertaid,
                    dewetra2_vw.area,
                    count(*) AS cnt,
                    min(dewetra2_vw."timestamp") AS mn,
                    max(dewetra2_vw."timestamp") AS mx,
                    max(dewetra2_vw.indice_colore) AS col
                   FROM public.dewetra2_vw
                  GROUP BY dewetra2_vw.allertaid, (date(dewetra2_vw."timestamp")), dewetra2_vw.area) x
             JOIN public.dewetra_colori c ON ((c.id = x.col)))) y;




--
-- TOC entry 613 (class 1259 OID 8897065)
-- Name: elenco_superamenti_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.elenco_superamenti_vw AS
 SELECT x.allarmeid,
    x.createdate,
    x.datafine,
    x.idregola,
    x.colore,
    x.idvariabile,
    x.soglia,
    x.idstazione,
    x.name,
    x.soglia1,
    x.soglia2,
    x.soglia3,
    x.txt,
    "substring"((x.txt)::text, '[0-9][0-9]:[0-9][0-9]'::text) AS oralocale,
        CASE
            WHEN ((x.idvariabile)::text ~~ '%13215%'::text) THEN 'idro'::text
            ELSE 'pluvio'::text
        END AS tipo,
        CASE
            WHEN ((x.idvariabile)::text ~~ '%13215%'::text) THEN "substring"((x.txt)::text, '[0-9]+,[0-9]+ m'::text)
            ELSE "substring"((x.txt)::text, '[0-9]+,[0-9]+ mm'::text)
        END AS livello,
        CASE
            WHEN (x.soglia = 1) THEN x.soglia1
            WHEN (x.soglia = 2) THEN x.soglia2
            ELSE x.soglia3
        END AS sogliaregola
   FROM ( SELECT al.allarmeid,
            al.createdate,
            al.datafine,
            al.idregola,
            r.colore,
            rac.idvariabile,
            rac.soglia,
            st.id_ AS idstazione,
            st.name,
            sv.soglia1,
            sv.soglia2,
            sv.soglia3,
            ( SELECT s.testo AS txt
                   FROM public.allerter_sms s
                  WHERE (((s.tipo)::text = 'superamento'::text) AND (s.param = al.allarmeid) AND ((s.testo)::text ~ '[0-9][0-9]:[0-9][0-9]'::text))
                 LIMIT 1) AS txt
           FROM ((((public.bollettino_allarme al
             LEFT JOIN public.bollettino_regolaallarme r ON ((al.idregola = r.id_)))
             LEFT JOIN public.bollettino_regolaallarmecondizione rac ON (((rac.idregola = r.id_) AND (rac.id_ = ( SELECT min(r2.id_) AS min
                   FROM public.bollettino_regolaallarmecondizione r2
                  WHERE (r2.idregola = r.id_))))))
             LEFT JOIN public.bollettino_stazione st ON (((st.id_)::text = (rac.idstazione)::text)))
             LEFT JOIN public.bollettino_stazionevariabile sv ON ((((sv.idstazione)::text = (st.id_)::text) AND ((sv.idvariabile)::text = (rac.idvariabile)::text))))) x
  ORDER BY x.createdate DESC,
        CASE
            WHEN ((x.idvariabile)::text ~~ '%13215%'::text) THEN 'idro'::text
            ELSE 'pluvio'::text
        END, x.name, x.soglia;



--
-- TOC entry 349 (class 1259 OID 692710)
-- Name: idro; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.idro AS
 SELECT DISTINCT s.id_ AS stazione,
    s.name
   FROM ((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile v ON (((s.id_)::text = (v.idstazione)::text)))
     JOIN public.bollettino_valoresensore val ON (((val.idstazione)::text = (v.idstazione)::text)))
  WHERE ((v.idvariabile)::text ~~ '%B13215%'::text);


--
-- TOC entry 407 (class 1259 OID 693050)
-- Name: lr7_rubrica_gerarchia; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_gerarchia AS
 SELECT x.id_gruppo,
    x.nome,
    x.fk_sito_proprietario,
    x.sottogruppi,
    string_agg((rn.id_nominativo)::text, ','::text) AS nominativi
   FROM ((( SELECT rg.id_gruppo,
            rg.nome,
            rg.fk_sito_proprietario,
            string_agg((rg2.id_gruppo)::text, ','::text) AS sottogruppi
           FROM ((public.rubrica_rubricagruppo rg
             LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = rg.id_gruppo)))
             LEFT JOIN public.rubrica_rubricagruppo rg2 ON (((rg2.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg2.disabled))))
          WHERE (NOT rg.disabled)
          GROUP BY rg.id_gruppo, rg.nome, rg.fk_sito_proprietario) x
     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((x.id_gruppo = rgn.fk_gruppo)))
     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
  GROUP BY x.id_gruppo, x.fk_sito_proprietario, x.nome, x.sottogruppi;


--
-- TOC entry 411 (class 1259 OID 693064)
-- Name: lr7_rubrica_supporto1_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_supporto1_vw AS
 SELECT x.gruppo,
    x.id_contatto,
    x.cognome,
    x.nome,
    x.ruolo,
    x.specifica_ruolo,
    x.indirizzo,
    x.tipo_contatto,
    x.contatto,
    x.nomegruppo,
    x.nomeruolo,
    x.zona,
    x.sottozona,
    replace(x.zona, 'Allerta Zona '::text, 'ZONA '::text) AS z,
    replace(x.sottozona, 'Allerta Zona '::text, 'ZONA '::text) AS sz
   FROM ( WITH RECURSIVE grafo_gruppi(gruppo, id_contatto, cognome, nome, ruolo, specifica_ruolo, indirizzo, tipo_contatto, contatto, nomegruppo, nomeruolo, zona, sottozona) AS (
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    rg.nome AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                    NULL::text AS zona,
                    NULL::text AS sottozona
                   FROM (((((public.rubrica_rubricagruppo rg
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                  WHERE (((rg.nome)::text = 'Rubrica Allerta'::text) AND (rg.fk_sito_proprietario = 20181) AND (NOT (rg.disabled = true)))
                UNION
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    (concat(gg.nomegruppo, '/', rg.nome))::character varying(512) AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                        CASE
                            WHEN ((gg.zona IS NULL) AND ((rg.nome)::text ~~ 'Allerta Zona%'::text) AND (NOT (((rg.nome)::text ~~ '%1'::text) OR ((rg.nome)::text ~~ '%2'::text) OR ((rg.nome)::text ~~ '%3'::text)))) THEN (rg.nome)::text
                            ELSE gg.zona
                        END AS zona,
                        CASE
                            WHEN ((gg.sottozona IS NULL) AND ((rg.nome)::text ~~ 'Allerta Zona%'::text) AND (((rg.nome)::text ~~ '%1'::text) OR ((rg.nome)::text ~~ '%2'::text) OR ((rg.nome)::text ~~ '%3'::text))) THEN (rg.nome)::text
                            ELSE gg.sottozona
                        END AS sottozona
                   FROM (((((((grafo_gruppi gg
                     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = gg.gruppo)))
                     LEFT JOIN public.rubrica_rubricagruppo rg ON (((rg.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg.disabled))))
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                )
         SELECT grafo_gruppi.gruppo,
            grafo_gruppi.id_contatto,
            grafo_gruppi.cognome,
            grafo_gruppi.nome,
            grafo_gruppi.ruolo,
            grafo_gruppi.specifica_ruolo,
            grafo_gruppi.indirizzo,
            grafo_gruppi.tipo_contatto,
            grafo_gruppi.contatto,
            grafo_gruppi.nomegruppo,
            grafo_gruppi.nomeruolo,
            grafo_gruppi.zona,
            grafo_gruppi.sottozona
           FROM grafo_gruppi
          WHERE (grafo_gruppi.contatto IS NOT NULL)
          ORDER BY grafo_gruppi.gruppo, grafo_gruppi.cognome, grafo_gruppi.nome, grafo_gruppi.tipo_contatto, grafo_gruppi.contatto) x;


--
-- TOC entry 412 (class 1259 OID 693069)
-- Name: lr7_rubrica_supporto2_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_supporto2_vw AS
 SELECT x.gruppo,
    x.id_contatto,
    x.cognome,
    x.nome,
    x.ruolo,
    x.specifica_ruolo,
    x.indirizzo,
    x.tipo_contatto,
    x.contatto,
    x.nomegruppo,
    x.nomeruolo,
    x.fiume,
    y.nome AS fiume2
   FROM (( WITH RECURSIVE grafo_gruppi(gruppo, id_contatto, cognome, nome, ruolo, specifica_ruolo, indirizzo, tipo_contatto, contatto, nomegruppo, nomeruolo, fiume) AS (
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    rg.nome AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                    NULL::text AS fiume
                   FROM (((((public.rubrica_rubricagruppo rg
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                  WHERE (((rg.nome)::text = 'Idrometri'::text) AND (rg.fk_sito_proprietario = 20181) AND (NOT (rg.disabled = true)))
                UNION
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    (concat(gg.nomegruppo, '/', rg.nome))::character varying(512) AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                        CASE
                            WHEN ((gg.fiume IS NULL) AND ((rg.nome)::text ~~ 'FIUME%'::text)) THEN (rg.nome)::text
                            ELSE gg.fiume
                        END AS fiume
                   FROM (((((((grafo_gruppi gg
                     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = gg.gruppo)))
                     LEFT JOIN public.rubrica_rubricagruppo rg ON (((rg.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg.disabled))))
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                )
         SELECT grafo_gruppi.gruppo,
            grafo_gruppi.id_contatto,
            grafo_gruppi.cognome,
            grafo_gruppi.nome,
            grafo_gruppi.ruolo,
            grafo_gruppi.specifica_ruolo,
            grafo_gruppi.indirizzo,
            grafo_gruppi.tipo_contatto,
            grafo_gruppi.contatto,
            grafo_gruppi.nomegruppo,
            grafo_gruppi.nomeruolo,
            grafo_gruppi.fiume
           FROM grafo_gruppi
          WHERE (grafo_gruppi.contatto IS NOT NULL)
          ORDER BY grafo_gruppi.gruppo, grafo_gruppi.cognome, grafo_gruppi.nome, grafo_gruppi.tipo_contatto, grafo_gruppi.contatto) x
     JOIN ( SELECT DISTINCT rg.nome
           FROM public.rubrica_rubricagruppo rg
          WHERE (((rg.nome)::text ~~ 'FIUME%'::text) AND (rg.fk_sito_proprietario = 20181))) y ON (((x.fiume = (y.nome)::text) OR (x.fiume IS NULL))));


--
-- TOC entry 413 (class 1259 OID 693074)
-- Name: lr7_rubrica_supporto3_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_supporto3_vw AS
 SELECT x.gruppo,
    x.id_contatto,
    x.cognome,
    x.nome,
    x.ruolo,
    x.specifica_ruolo,
    x.indirizzo,
    x.tipo_contatto,
    x.contatto,
    x.nomegruppo,
    x.nomeruolo
   FROM ( WITH RECURSIVE grafo_gruppi(gruppo, id_contatto, cognome, nome, ruolo, specifica_ruolo, indirizzo, tipo_contatto, contatto, nomegruppo, nomeruolo) AS (
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    rg.nome AS nomegruppo,
                    rr.descrizione AS nomeruolo
                   FROM (((((public.rubrica_rubricagruppo rg
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                  WHERE (((rg.nome)::text ~~ 'Valanghe%'::text) AND (rg.fk_sito_proprietario = 20181) AND (NOT (rg.disabled = true)))
                UNION
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    (concat(gg.nomegruppo, '/', rg.nome))::character varying(512) AS nomegruppo,
                    rr.descrizione AS nomeruolo
                   FROM (((((((grafo_gruppi gg
                     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = gg.gruppo)))
                     LEFT JOIN public.rubrica_rubricagruppo rg ON (((rg.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg.disabled))))
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                )
         SELECT grafo_gruppi.gruppo,
            grafo_gruppi.id_contatto,
            grafo_gruppi.cognome,
            grafo_gruppi.nome,
            grafo_gruppi.ruolo,
            grafo_gruppi.specifica_ruolo,
            grafo_gruppi.indirizzo,
            grafo_gruppi.tipo_contatto,
            grafo_gruppi.contatto,
            grafo_gruppi.nomegruppo,
            grafo_gruppi.nomeruolo
           FROM grafo_gruppi
          WHERE (grafo_gruppi.contatto IS NOT NULL)
          ORDER BY grafo_gruppi.gruppo, grafo_gruppi.cognome, grafo_gruppi.nome, grafo_gruppi.tipo_contatto, grafo_gruppi.contatto) x;


--
-- TOC entry 414 (class 1259 OID 693079)
-- Name: lr7_rubrica_supporto4_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_supporto4_vw AS
 SELECT x.gruppo,
    x.id_contatto,
    x.cognome,
    x.nome,
    x.ruolo,
    x.specifica_ruolo,
    x.indirizzo,
    x.tipo_contatto,
    x.contatto,
    x.nomegruppo,
    x.nomeruolo,
    x.fiume,
    y.nome AS fiume2
   FROM (( WITH RECURSIVE grafo_gruppi(gruppo, id_contatto, cognome, nome, ruolo, specifica_ruolo, indirizzo, tipo_contatto, contatto, nomegruppo, nomeruolo, fiume) AS (
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    rg.nome AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                    NULL::text AS fiume
                   FROM (((((public.rubrica_rubricagruppo rg
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                  WHERE (((rg.nome)::text = 'Rubrica Monitoraggio'::text) AND (rg.fk_sito_proprietario = 20181) AND (NOT (rg.disabled = true)))
                UNION
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    (concat(gg.nomegruppo, '/', rg.nome))::character varying(512) AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                        CASE
                            WHEN ((gg.fiume IS NULL) AND ((rg.nome)::text ~~ 'Monitoraggio%'::text)) THEN (rg.nome)::text
                            ELSE gg.fiume
                        END AS fiume
                   FROM (((((((grafo_gruppi gg
                     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = gg.gruppo)))
                     LEFT JOIN public.rubrica_rubricagruppo rg ON (((rg.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg.disabled))))
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                )
         SELECT grafo_gruppi.gruppo,
            grafo_gruppi.id_contatto,
            grafo_gruppi.cognome,
            grafo_gruppi.nome,
            grafo_gruppi.ruolo,
            grafo_gruppi.specifica_ruolo,
            grafo_gruppi.indirizzo,
            grafo_gruppi.tipo_contatto,
            grafo_gruppi.contatto,
            grafo_gruppi.nomegruppo,
            grafo_gruppi.nomeruolo,
            grafo_gruppi.fiume
           FROM grafo_gruppi
          WHERE (grafo_gruppi.contatto IS NOT NULL)
          ORDER BY grafo_gruppi.gruppo, grafo_gruppi.cognome, grafo_gruppi.nome, grafo_gruppi.tipo_contatto, grafo_gruppi.contatto) x
     JOIN ( SELECT DISTINCT rg.nome
           FROM public.rubrica_rubricagruppo rg
          WHERE (((rg.nome)::text ~~ 'Monitoraggio%'::text) AND (rg.fk_sito_proprietario = 20181))) y ON (((x.fiume = (y.nome)::text) OR (x.fiume IS NULL))));


--
-- TOC entry 415 (class 1259 OID 693084)
-- Name: lr7_rubrica_supporto5_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_supporto5_vw AS
 SELECT x.gruppo,
    x.id_contatto,
    x.cognome,
    x.nome,
    x.ruolo,
    x.specifica_ruolo,
    x.indirizzo,
    x.tipo_contatto,
    x.contatto,
    x.nomegruppo,
    x.nomeruolo,
    x.fiume,
    y.nome AS fiume2
   FROM (( WITH RECURSIVE grafo_gruppi(gruppo, id_contatto, cognome, nome, ruolo, specifica_ruolo, indirizzo, tipo_contatto, contatto, nomegruppo, nomeruolo, fiume) AS (
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    rg.nome AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                    NULL::text AS fiume
                   FROM (((((public.rubrica_rubricagruppo rg
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                  WHERE (((rg.nome)::text = 'Pluviometri'::text) AND (rg.fk_sito_proprietario = 20181) AND (NOT (rg.disabled = true)))
                UNION
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    (concat(gg.nomegruppo, '/', rg.nome))::character varying(512) AS nomegruppo,
                    rr.descrizione AS nomeruolo,
                        CASE
                            WHEN ((gg.fiume IS NULL) AND ((rg.nome)::text ~~ 'PLV.%'::text)) THEN (rg.nome)::text
                            ELSE gg.fiume
                        END AS fiume
                   FROM (((((((grafo_gruppi gg
                     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = gg.gruppo)))
                     LEFT JOIN public.rubrica_rubricagruppo rg ON (((rg.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg.disabled))))
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                )
         SELECT grafo_gruppi.gruppo,
            grafo_gruppi.id_contatto,
            grafo_gruppi.cognome,
            grafo_gruppi.nome,
            grafo_gruppi.ruolo,
            grafo_gruppi.specifica_ruolo,
            grafo_gruppi.indirizzo,
            grafo_gruppi.tipo_contatto,
            grafo_gruppi.contatto,
            grafo_gruppi.nomegruppo,
            grafo_gruppi.nomeruolo,
            grafo_gruppi.fiume
           FROM grafo_gruppi
          WHERE (grafo_gruppi.contatto IS NOT NULL)
          ORDER BY grafo_gruppi.gruppo, grafo_gruppi.cognome, grafo_gruppi.nome, grafo_gruppi.tipo_contatto, grafo_gruppi.contatto) x
     JOIN ( SELECT DISTINCT rg.nome
           FROM public.rubrica_rubricagruppo rg
          WHERE (((rg.nome)::text ~~ 'PLV.%'::text) AND (rg.fk_sito_proprietario = 20181))) y ON (((x.fiume = (y.nome)::text) OR ((x.fiume IS NULL) AND (NOT ((x.nomegruppo)::text ~~ 'Pluviometri/PLUVIOMETRI%'::text))))));


--
-- TOC entry 620 (class 1259 OID 53613100)
-- Name: lr7_rubrica_supporto6_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.lr7_rubrica_supporto6_vw AS
 SELECT x.gruppo,
    x.id_contatto,
    x.cognome,
    x.nome,
    x.ruolo,
    x.specifica_ruolo,
    x.indirizzo,
    x.tipo_contatto,
    x.contatto,
    x.nomegruppo,
    x.nomeruolo
   FROM ( WITH RECURSIVE grafo_gruppi(gruppo, id_contatto, cognome, nome, ruolo, specifica_ruolo, indirizzo, tipo_contatto, contatto, nomegruppo, nomeruolo) AS (
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    rg.nome AS nomegruppo,
                    rr.descrizione AS nomeruolo
                   FROM (((((public.rubrica_rubricagruppo rg
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                  WHERE (((rg.nome)::text ~~ 'Allerta Diga%'::text) AND (rg.fk_sito_proprietario = 20181) AND (NOT (rg.disabled = true)))
                UNION
                 SELECT rg.id_gruppo AS gruppo,
                    rc.id_contatto,
                    rn.cognome,
                    rn.nome,
                    rgn.fk_ruolo,
                    rgn.specifica_ruolo,
                    rn.indirizzo,
                    rca.nome AS tipo_contatto,
                    rc.contatto,
                    (concat(gg.nomegruppo, '/', rg.nome))::character varying(512) AS nomegruppo,
                    rr.descrizione AS nomeruolo
                   FROM (((((((grafo_gruppi gg
                     LEFT JOIN public.rubrica_rubricagruppogruppi rgg ON ((rgg.fk_gruppo_padre = gg.gruppo)))
                     LEFT JOIN public.rubrica_rubricagruppo rg ON (((rg.id_gruppo = rgg.fk_gruppo_figlio) AND (NOT rg.disabled))))
                     LEFT JOIN public.rubrica_rubricagrupponominativi rgn ON ((rgn.fk_gruppo = rg.id_gruppo)))
                     LEFT JOIN public.rubrica_rubricanominativo rn ON (((rn.id_nominativo = rgn.fk_nominativo) AND (NOT rn.disabled))))
                     LEFT JOIN public.rubrica_rubricacontatto rc ON (((rc.fk_nominativo = rn.id_nominativo) AND (rc.data_fine_validita IS NULL))))
                     LEFT JOIN public.rubrica_rubricaruolo rr ON ((rr.id_ruolo = rgn.fk_ruolo)))
                     LEFT JOIN public.rubrica_rubricacanale rca ON ((rca.id_canale = rc.fk_canale)))
                )
         SELECT grafo_gruppi.gruppo,
            grafo_gruppi.id_contatto,
            grafo_gruppi.cognome,
            grafo_gruppi.nome,
            grafo_gruppi.ruolo,
            grafo_gruppi.specifica_ruolo,
            grafo_gruppi.indirizzo,
            grafo_gruppi.tipo_contatto,
            grafo_gruppi.contatto,
            grafo_gruppi.nomegruppo,
            grafo_gruppi.nomeruolo
           FROM grafo_gruppi
          WHERE (grafo_gruppi.contatto IS NOT NULL)
          ORDER BY grafo_gruppi.gruppo, grafo_gruppi.cognome, grafo_gruppi.nome, grafo_gruppi.tipo_contatto, grafo_gruppi.contatto) x;


--
-- TOC entry 600 (class 1259 OID 1467544)
-- Name: meteomont2_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.meteomont2_vw AS
 SELECT y.titolo,
    y.url,
    y.username,
    y.userid,
    y.createdate,
    y.createday,
    y.numero,
    y.anno,
    y.articleid,
    y.fileentryid,
    ( SELECT allerter_sms.sottotipo
           FROM public.allerter_sms
          WHERE (((allerter_sms.tipo)::text = 'comunicazione'::text) AND (allerter_sms.datainvio > y.createdate) AND (allerter_sms.datainvio < (y.createdate + '12:00:00'::interval)) AND (upper((allerter_sms.testo)::text) ~~ '%METEOMONT%'::text))
         LIMIT 1) AS invio,
    ( SELECT allerter_email.sottotipo
           FROM public.allerter_email
          WHERE (((allerter_email.tipo)::text = 'comunicazione'::text) AND (allerter_email.datainvio > y.createdate) AND (allerter_email.datainvio < (y.createdate + '12:00:00'::interval)) AND (upper(allerter_email.testo) ~~ '%METEOMONT%'::text))
         LIMIT 1) AS invio_mail
   FROM ( SELECT x.titolo,
            x.fileuuid,
            x.username,
            x.userid,
            x.createdate,
            x.createday,
            x.numero,
            x.anno,
            x.articleid,
            f.fileentryid,
            ((((((('/documents/'::text || f.repositoryid) || '/'::text) || f.folderid) || '/'::text) || (f.filename)::text) || '/'::text) || (f.uuid_)::text) AS url
           FROM (( SELECT jl.title AS titolo,
                    (''::text || (( SELECT regexp_matches(j.content, '.+\"uuid\":\"(.+)\".+'::text) AS regexp_matches))[1]) AS fileuuid,
                    j.username,
                    j.userid,
                    j.createdate,
                    (j.createdate)::date AS createday,
                    date_part('doy'::text, j.createdate) AS numero,
                    date_part('year'::text, j.createdate) AS anno,
                    j.articleid
                   FROM (public.journalarticle j
                     JOIN public.journalarticlelocalization jl ON (((jl.articlepk = j.id_) AND ((jl.languageid)::text = 'it_IT'::text))))
                  WHERE (((j.ddmstructurekey)::text = '227847'::text) AND (j.modifieddate = ( SELECT max(j2.modifieddate) AS max
                           FROM public.journalarticle j2
                          WHERE ((j2.articleid)::text = (j.articleid)::text))))
                  ORDER BY j.createdate DESC) x
             JOIN public.dlfileentry f ON (((f.uuid_)::text = x.fileuuid)))) y;


--
-- TOC entry 599 (class 1259 OID 1466315)
-- Name: meteomont_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.meteomont_vw AS
 SELECT x.titolo,
    ((((((('/documents/'::text || f.repositoryid) || '/'::text) || f.folderid) || '/'::text) || (f.filename)::text) || '/'::text) || (f.uuid_)::text) AS url
   FROM (( SELECT jl.title AS titolo,
            (''::text || (( SELECT regexp_matches(j.content, '.+\"uuid\":\"(.+)\".+'::text) AS regexp_matches))[1]) AS fileuuid
           FROM (public.journalarticle j
             JOIN public.journalarticlelocalization jl ON (((jl.articlepk = j.id_) AND ((jl.languageid)::text = 'it_IT'::text))))
          WHERE (((j.ddmstructurekey)::text = '227847'::text) AND (j.modifieddate = ( SELECT max(j2.modifieddate) AS max
                   FROM public.journalarticle j2
                  WHERE ((j2.articleid)::text = (j.articleid)::text))))
          ORDER BY j.createdate DESC) x
     JOIN public.dlfileentry f ON (((f.uuid_)::text = x.fileuuid)));


--
-- TOC entry 433 (class 1259 OID 693174)
-- Name: monit_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.monit_vw AS
 SELECT bollettino_bollettino.uuid_,
    bollettino_bollettino.bollettinoid,
    bollettino_bollettino.groupid,
    bollettino_bollettino.companyid,
    bollettino_bollettino.userid,
    bollettino_bollettino.username,
    bollettino_bollettino.createdate,
    bollettino_bollettino.modifieddate,
    bollettino_bollettino.stato,
    bollettino_bollettino.idapprovatore,
    bollettino_bollettino.dataapprovazione,
    bollettino_bollettino.numero,
    bollettino_bollettino.progressivo,
    bollettino_bollettino.anno,
    bollettino_bollettino.dataemissione,
    bollettino_bollettino.datainizio,
    bollettino_bollettino.datafine,
    bollettino_bollettino.notemeteo,
    bollettino_bollettino.stringameteo,
    bollettino_bollettino.link,
    bollettino_bollettino.ultimo
   FROM public.bollettino_bollettino;


--
-- TOC entry 601 (class 1259 OID 1704296)
-- Name: new_area_rubrica_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.new_area_rubrica_vw AS
 SELECT DISTINCT x.id,
    x.tag,
    x.nome,
    x.recapito,
        CASE
            WHEN ((x.tipo)::text = 'EMAIL'::text) THEN 'EMAIL'::text
            ELSE 'SMS'::text
        END AS tipo
   FROM ( SELECT lr7_rubrica_supporto1_vw.id_contatto AS id,
            (lr7_rubrica_supporto1_vw.z || '1'::text) AS tag,
            (((((lr7_rubrica_supporto1_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto1_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto1_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto1_vw.contatto AS recapito,
            lr7_rubrica_supporto1_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto1_vw
          WHERE ((lr7_rubrica_supporto1_vw.z IS NOT NULL) AND (lr7_rubrica_supporto1_vw.sz IS NULL))
        UNION ALL
         SELECT lr7_rubrica_supporto1_vw.id_contatto AS id,
            (lr7_rubrica_supporto1_vw.z || '2'::text) AS tag,
            (((((lr7_rubrica_supporto1_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto1_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto1_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto1_vw.contatto AS recapito,
            lr7_rubrica_supporto1_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto1_vw
          WHERE ((lr7_rubrica_supporto1_vw.z IS NOT NULL) AND (lr7_rubrica_supporto1_vw.sz IS NULL))
        UNION ALL
         SELECT lr7_rubrica_supporto1_vw.id_contatto AS id,
            (lr7_rubrica_supporto1_vw.z || '3'::text) AS tag,
            (((((lr7_rubrica_supporto1_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto1_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto1_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto1_vw.contatto AS recapito,
            lr7_rubrica_supporto1_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto1_vw
          WHERE ((lr7_rubrica_supporto1_vw.z IS NOT NULL) AND (lr7_rubrica_supporto1_vw.z = ANY (ARRAY['ZONA F'::text, 'ZONA D'::text])) AND (lr7_rubrica_supporto1_vw.sz IS NULL))
        UNION ALL
         SELECT lr7_rubrica_supporto1_vw.id_contatto AS id,
            lr7_rubrica_supporto1_vw.sz AS tag,
            (((((lr7_rubrica_supporto1_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto1_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto1_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto1_vw.contatto AS recapito,
            lr7_rubrica_supporto1_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto1_vw
          WHERE (lr7_rubrica_supporto1_vw.sz IS NOT NULL)
        UNION ALL
         SELECT lr7_rubrica_supporto1_vw.id_contatto AS id,
            'ZONE_SEMPRE'::text AS tag,
            (((((lr7_rubrica_supporto1_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto1_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto1_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto1_vw.contatto AS recapito,
            lr7_rubrica_supporto1_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto1_vw
          WHERE ((lr7_rubrica_supporto1_vw.z IS NULL) AND (lr7_rubrica_supporto1_vw.sz IS NULL))) x
  ORDER BY x.recapito;


--
-- TOC entry 621 (class 1259 OID 53613775)
-- Name: new_diga_rubrica_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.new_diga_rubrica_vw AS
 SELECT DISTINCT ((x.id || '_'::text) || split_part((x.nomegruppo)::text, '/'::text, 1)) AS id,
    x.tag,
    x.nome,
    x.recapito,
        CASE
            WHEN ((x.tipo)::text = 'EMAIL'::text) THEN 'EMAIL'::text
            ELSE 'SMS'::text
        END AS tipo
   FROM ( SELECT lr7_rubrica_supporto6_vw.id_contatto AS id,
            lr7_rubrica_supporto6_vw.nomegruppo,
            split_part((lr7_rubrica_supporto6_vw.nomegruppo)::text, '/'::text, 1) AS tag,
            (((((lr7_rubrica_supporto6_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto6_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto6_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto6_vw.contatto AS recapito,
            lr7_rubrica_supporto6_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto6_vw
          WHERE ((lr7_rubrica_supporto6_vw.nomegruppo)::text ~~ 'Allerta Diga%'::text)) x;


--
-- TOC entry 602 (class 1259 OID 1705432)
-- Name: new_fiume_rubrica_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.new_fiume_rubrica_vw AS
 SELECT DISTINCT x.id,
    x.tag,
    x.nome,
    x.recapito,
        CASE
            WHEN ((x.tipo)::text = 'EMAIL'::text) THEN 'EMAIL'::text
            ELSE 'SMS'::text
        END AS tipo
   FROM ( SELECT lr7_rubrica_supporto2_vw.id_contatto AS id,
            (lr7_rubrica_supporto2_vw.fiume || '-NT'::text) AS tag,
            (((((lr7_rubrica_supporto2_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto2_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto2_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto2_vw.contatto AS recapito,
            lr7_rubrica_supporto2_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto2_vw
          WHERE (((lr7_rubrica_supporto2_vw.nomegruppo)::text ~~ '%-NT%'::text) AND ((lr7_rubrica_supporto2_vw.nomegruppo)::text !~~ '%SEMPRE-NT%'::text))
        UNION ALL
         SELECT lr7_rubrica_supporto2_vw.id_contatto AS id,
            (lr7_rubrica_supporto2_vw.fiume || '-TT'::text) AS tag,
            (((((lr7_rubrica_supporto2_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto2_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto2_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto2_vw.contatto AS recapito,
            lr7_rubrica_supporto2_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto2_vw
          WHERE (((lr7_rubrica_supporto2_vw.nomegruppo)::text !~~ '%-NT%'::text) AND ((lr7_rubrica_supporto2_vw.nomegruppo)::text !~~ '%SEMPRE-TT%'::text))
        UNION ALL
         SELECT lr7_rubrica_supporto2_vw.id_contatto AS id,
            'Fiume_sempre_NT'::text AS tag,
            (((((lr7_rubrica_supporto2_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto2_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto2_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto2_vw.contatto AS recapito,
            lr7_rubrica_supporto2_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto2_vw
          WHERE ((lr7_rubrica_supporto2_vw.nomegruppo)::text ~~ '%SEMPRE-NT%'::text)
        UNION ALL
         SELECT lr7_rubrica_supporto2_vw.id_contatto AS id,
            'Fiume_sempre_TT'::text AS tag,
            (((((lr7_rubrica_supporto2_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto2_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto2_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto2_vw.contatto AS recapito,
            lr7_rubrica_supporto2_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto2_vw
          WHERE ((lr7_rubrica_supporto2_vw.nomegruppo)::text ~~ '%SEMPRE-TT%'::text)) x;


--
-- TOC entry 603 (class 1259 OID 1706170)
-- Name: new_meteomont_rubrica_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.new_meteomont_rubrica_vw AS
 SELECT DISTINCT x.id,
    x.tag,
    x.nome,
    x.recapito,
        CASE
            WHEN ((x.tipo)::text = 'EMAIL'::text) THEN 'EMAIL'::text
            ELSE 'SMS'::text
        END AS tipo
   FROM ( SELECT lr7_rubrica_supporto3_vw.id_contatto AS id,
            'Meteomont_sempre'::text AS tag,
            (((((lr7_rubrica_supporto3_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto3_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto3_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto3_vw.contatto AS recapito,
            lr7_rubrica_supporto3_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto3_vw
          WHERE ((lr7_rubrica_supporto3_vw.nomegruppo)::text ~~ 'Valanghe SEMPRE%'::text)
        UNION ALL
         SELECT lr7_rubrica_supporto3_vw.id_contatto AS id,
            'Meteomont_App_Romagnolo'::text AS tag,
            (((((lr7_rubrica_supporto3_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto3_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto3_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto3_vw.contatto AS recapito,
            lr7_rubrica_supporto3_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto3_vw
          WHERE ((lr7_rubrica_supporto3_vw.nomegruppo)::text ~~ 'Valanghe App. Romagnolo%'::text)
        UNION ALL
         SELECT lr7_rubrica_supporto3_vw.id_contatto AS id,
            'Meteomont_App_Emilia_Centrale'::text AS tag,
            (((((lr7_rubrica_supporto3_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto3_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto3_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto3_vw.contatto AS recapito,
            lr7_rubrica_supporto3_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto3_vw
          WHERE ((lr7_rubrica_supporto3_vw.nomegruppo)::text ~~ 'Valanghe App. E. Centrale%'::text)
        UNION ALL
         SELECT lr7_rubrica_supporto3_vw.id_contatto AS id,
            'Meteomont_App_Emilia_Occidentale'::text AS tag,
            (((((lr7_rubrica_supporto3_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto3_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto3_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto3_vw.contatto AS recapito,
            lr7_rubrica_supporto3_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto3_vw
          WHERE ((lr7_rubrica_supporto3_vw.nomegruppo)::text ~~ 'Valanghe App. E. Occidentale%'::text)) x;


--
-- TOC entry 604 (class 1259 OID 1706543)
-- Name: new_monitoraggio_rubrica_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.new_monitoraggio_rubrica_vw AS
 SELECT DISTINCT x.id,
    x.tag,
    x.nome,
    x.recapito,
        CASE
            WHEN ((x.tipo)::text = 'EMAIL'::text) THEN 'EMAIL'::text
            ELSE 'SMS'::text
        END AS tipo
   FROM ( SELECT lr7_rubrica_supporto4_vw.id_contatto AS id,
            COALESCE(regexp_replace(lr7_rubrica_supporto4_vw.fiume, 'Monitoraggio '::text, 'Monitoraggio_Fiume_'::text), 'Monitoraggio_sempre'::text) AS tag,
            (((((lr7_rubrica_supporto4_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto4_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto4_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto4_vw.contatto AS recapito,
            lr7_rubrica_supporto4_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto4_vw) x;


--
-- TOC entry 605 (class 1259 OID 1707696)
-- Name: new_pluviometro_rubrica_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.new_pluviometro_rubrica_vw AS
 SELECT DISTINCT x.id,
    x.tag,
    x.nome,
    x.recapito,
        CASE
            WHEN ((x.tipo)::text = 'EMAIL'::text) THEN 'EMAIL'::text
            ELSE 'SMS'::text
        END AS tipo
   FROM ( SELECT lr7_rubrica_supporto5_vw.id_contatto AS id,
            COALESCE(lr7_rubrica_supporto5_vw.fiume, 'PLV. SEMPRE'::text) AS tag,
            (((((lr7_rubrica_supporto5_vw.nome)::text || ' '::text) || (lr7_rubrica_supporto5_vw.cognome)::text) || ' - '::text) || regexp_replace((lr7_rubrica_supporto5_vw.nomegruppo)::text, '^.+[/\\]'::text, ''::text)) AS nome,
            lr7_rubrica_supporto5_vw.contatto AS recapito,
            lr7_rubrica_supporto5_vw.tipo_contatto AS tipo
           FROM public.lr7_rubrica_supporto5_vw) x;


--
-- TOC entry 434 (class 1259 OID 693178)
-- Name: nominativi_duplicati_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.nominativi_duplicati_vw AS
 SELECT c1.id_nominativo AS id1,
    c2.id_nominativo AS id2,
    c1.cognome,
    c1.nome,
    c1.contatti
   FROM (( SELECT rn.id_nominativo,
            upper(btrim((rn.cognome)::text)) AS cognome,
            upper(btrim((rn.nome)::text)) AS nome,
            array_to_string(array_agg(btrim(upper((rc.contatto)::text))), '|'::text) AS contatti
           FROM (public.rubrica_rubricanominativo rn
             LEFT JOIN ( SELECT rubrica_rubricacontatto.id_contatto,
                    rubrica_rubricacontatto.fk_nominativo,
                    rubrica_rubricacontatto.fk_canale,
                    rubrica_rubricacontatto.contatto,
                    rubrica_rubricacontatto.allertamento,
                    rubrica_rubricacontatto.fk_utente_creazione,
                    rubrica_rubricacontatto.data_creazione,
                    rubrica_rubricacontatto.fk_utente_modifica,
                    rubrica_rubricacontatto.data_modifica,
                    rubrica_rubricacontatto.data_fine_validita,
                    rubrica_rubricacontatto.modifica_minore
                   FROM public.rubrica_rubricacontatto
                  ORDER BY rubrica_rubricacontatto.contatto) rc ON ((rc.fk_nominativo = rn.id_nominativo)))
          GROUP BY rn.id_nominativo, rn.cognome, rn.nome
          ORDER BY (array_to_string(array_agg(btrim(upper((rc.contatto)::text))), '|'::text))) c1
     JOIN ( SELECT rn.id_nominativo,
            upper(btrim((rn.cognome)::text)) AS cognome,
            upper(btrim((rn.nome)::text)) AS nome,
            array_to_string(array_agg(btrim(upper((rc.contatto)::text))), '|'::text) AS contatti
           FROM (public.rubrica_rubricanominativo rn
             LEFT JOIN ( SELECT rubrica_rubricacontatto.id_contatto,
                    rubrica_rubricacontatto.fk_nominativo,
                    rubrica_rubricacontatto.fk_canale,
                    rubrica_rubricacontatto.contatto,
                    rubrica_rubricacontatto.allertamento,
                    rubrica_rubricacontatto.fk_utente_creazione,
                    rubrica_rubricacontatto.data_creazione,
                    rubrica_rubricacontatto.fk_utente_modifica,
                    rubrica_rubricacontatto.data_modifica,
                    rubrica_rubricacontatto.data_fine_validita,
                    rubrica_rubricacontatto.modifica_minore
                   FROM public.rubrica_rubricacontatto
                  ORDER BY rubrica_rubricacontatto.contatto) rc ON ((rc.fk_nominativo = rn.id_nominativo)))
          GROUP BY rn.id_nominativo, rn.cognome, rn.nome
          ORDER BY (array_to_string(array_agg(btrim(upper((rc.contatto)::text))), '|'::text))) c2 ON (((c1.cognome = c2.cognome) AND (c1.nome = c2.nome) AND (c1.contatti = c2.contatti) AND (c1.id_nominativo < c2.id_nominativo))))
  ORDER BY c1.id_nominativo;


--
-- TOC entry 456 (class 1259 OID 693286)
-- Name: pluvio; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.pluvio AS
 SELECT DISTINCT s.id_ AS stazione,
    s.name
   FROM ((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile v ON (((s.id_)::text = (v.idstazione)::text)))
     JOIN public.bollettino_valoresensore val ON (((val.idstazione)::text = (v.idstazione)::text)))
  WHERE (((v.idvariabile)::text ~~ '%B13011%'::text) AND ((val.idvariabile)::text = (v.idvariabile)::text));


--
-- TOC entry 486 (class 1259 OID 693434)
-- Name: regole_condizioni_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.regole_condizioni_vw AS
 SELECT ra.id_,
    ra.nome,
    ra.descrizione,
    ra.attivo,
    ra.colore,
    rac.id_ AS idcondizione,
    rac.idvariabile,
    rac.idstazione,
    COALESCE(i.nomerubrica, p.nomerubrica, s.name) AS nomerubrica
   FROM ((((public.bollettino_regolaallarme ra
     JOIN public.bollettino_regolaallarmecondizione rac ON ((ra.id_ = rac.idregola)))
     LEFT JOIN public.bollettino_idrometro i ON ((((rac.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) AND ((rac.idstazione)::text = (i.stazioneid)::text))))
     LEFT JOIN public.bollettino_pluviometro p ON ((((rac.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND ((rac.idstazione)::text = (p.stazioneid)::text))))
     LEFT JOIN public.bollettino_stazione s ON (((rac.idstazione)::text = (s.id_)::text)))
  ORDER BY ra.id_, rac.id_;


--
-- TOC entry 487 (class 1259 OID 693439)
-- Name: sensori_comuni_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.sensori_comuni_vw AS
 SELECT s.id_,
    s.name,
    sv.idvariabile,
    s.namebasin,
    s.namesubbasin,
    (s.attivo AND ((now() - (sv.dataultimovalore)::timestamp with time zone) < '3 days'::interval)) AS attivo,
    array_to_string(array_agg(DISTINCT replace((o2.nome)::text, 'Comune '::text, ''::text)), ', '::text) AS comuni,
    (('_'::text || array_to_string(array_agg(DISTINCT o2.id_gruppo), '_'::text)) || '_'::text) AS idcomuni,
    COALESCE(sv3.idvariabile, sv2.idvariabile) AS idvariabilevera,
    (NOT (EXISTS ( SELECT d.idstazione,
            d.idvariabile
           FROM public.bollettino_disattivazionesensore d
          WHERE (((d.idstazione)::text = (s.id_)::text) AND ((d.idvariabile)::text = (sv.idvariabile)::text))))) AS funzionante,
    i.sogliaspike,
    sv.soglia1,
    sv.soglia2,
    sv.soglia3
   FROM ((((((((((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile sv ON (((s.id_)::text = (sv.idstazione)::text)))
     JOIN public.bollettino_regolaallarmecondizione c2 ON ((((s.id_)::text = (c2.idstazione)::text) AND ((sv.idvariabile)::text = (c2.idvariabile)::text) AND (c2.id_ = ( SELECT min(rac2.id_) AS min
           FROM public.bollettino_regolaallarmecondizione rac2
          WHERE (rac2.idregola = c2.idregola))))))
     JOIN public.bollettino_regolaallarme ra ON ((ra.id_ = c2.idregola)))
     LEFT JOIN public.bollettino_idrometro i ON ((((i.stazioneid)::text = (c2.idstazione)::text) AND ((c2.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text))))
     LEFT JOIN public.bollettino_pluviometro p ON ((((p.stazioneid)::text = (c2.idstazione)::text) AND ((c2.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))))
     LEFT JOIN public.rubrica_rubricagruppo o ON ((((o.nome)::text = (COALESCE(i.nomerubrica, p.nomerubrica))::text) AND (o.fk_sito_proprietario = 20181))))
     LEFT JOIN public.rubrica_rubricagruppogruppi uo ON ((uo.fk_gruppo_padre = o.id_gruppo)))
     LEFT JOIN public.rubrica_rubricagruppo o2 ON (((o2.id_gruppo = uo.fk_gruppo_figlio) AND (((o2.nome)::text ~~ 'Comune%'::text) OR ((o2.nome)::text ~~ 'Unione%'::text)))))
     LEFT JOIN public.bollettino_stazionevariabile sv2 ON ((((s.id_)::text = (sv2.idstazione)::text) AND ((sv.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND ((sv2.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text))))
     LEFT JOIN public.bollettino_stazionevariabile sv3 ON ((((s.id_)::text = (sv3.idstazione)::text) AND ((sv.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND ((sv3.idvariabile)::text = '1,0,900/1,-,-,-/B13011'::text))))
  WHERE ((sv.idvariabile)::text = ANY (ARRAY[('254,0,0/1,-,-,-/B13215'::character varying)::text, ('1,0,3600/1,-,-,-/B13011'::character varying)::text]))
  GROUP BY s.id_, s.name, sv.idvariabile, s.namebasin, s.namesubbasin, s.attivo, sv2.idvariabile, sv3.idvariabile, i.sogliaspike, sv.dataultimovalore, sv.soglia1, sv.soglia2, sv.soglia3
  ORDER BY sv.idvariabile DESC, s.name;


--
-- TOC entry 617 (class 1259 OID 21573047)
-- Name: regole_allarme2_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.regole_allarme2_vw AS
 SELECT v.id_,
    v.nome,
    v.descrizione,
    v.idvariabile,
    v.colore,
    v.attivo,
    v.nomerubrica AS principale,
    array_to_string(ARRAY( SELECT DISTINCT v4.nomerubrica
           FROM public.regole_condizioni_vw v4
          WHERE ((v4.id_ = v.id_) AND (v4.idcondizione > min(v.idcondizione)))
          ORDER BY v4.nomerubrica), ', '::text) AS altrisensori,
    sc.comuni,
    idro.nomebacino AS fiume,
    idro.nomesottobacino AS tratti
   FROM (((public.regole_condizioni_vw v
     JOIN ( SELECT v3.id_,
            min(v3.idcondizione) AS primaria
           FROM public.regole_condizioni_vw v3
          GROUP BY v3.id_
          ORDER BY v3.id_) v2 ON (((v.id_ = v2.id_) AND (v.idcondizione = v2.primaria))))
     LEFT JOIN public.sensori_comuni_vw sc ON ((((sc.id_)::text = (v.idstazione)::text) AND ((sc.idvariabile)::text = (v.idvariabile)::text))))
     LEFT JOIN public.bollettino_idrometro idro ON (((idro.nomerubrica)::text = (v.nomerubrica)::text)))
  GROUP BY v.id_, v.nome, v.descrizione, v.idvariabile, v.colore, v.attivo, v.nomerubrica, sc.comuni, idro.nomebacino, idro.nomesottobacino
  ORDER BY v.id_;


--
-- TOC entry 488 (class 1259 OID 693444)
-- Name: regole_allarme_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.regole_allarme_vw AS
 SELECT v.id_,
    v.nome,
    v.descrizione,
    v.idvariabile,
    v.colore,
    v.attivo,
    v.nomerubrica AS principale,
    array_to_string(ARRAY( SELECT DISTINCT v4.nomerubrica
           FROM public.regole_condizioni_vw v4
          WHERE ((v4.id_ = v.id_) AND (v4.idcondizione > min(v.idcondizione)))
          ORDER BY v4.nomerubrica), ', '::text) AS altrisensori,
    sc.comuni
   FROM ((public.regole_condizioni_vw v
     JOIN ( SELECT v3.id_,
            min(v3.idcondizione) AS primaria
           FROM public.regole_condizioni_vw v3
          GROUP BY v3.id_
          ORDER BY v3.id_) v2 ON (((v.id_ = v2.id_) AND (v.idcondizione = v2.primaria))))
     LEFT JOIN public.sensori_comuni_vw sc ON ((((sc.id_)::text = (v.idstazione)::text) AND ((sc.idvariabile)::text = (v.idvariabile)::text))))
  GROUP BY v.id_, v.nome, v.descrizione, v.idvariabile, v.colore, v.attivo, v.nomerubrica, sc.comuni
  ORDER BY v.id_;


--
-- TOC entry 618 (class 1259 OID 36840242)
-- Name: report_post_evento_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.report_post_evento_vw AS
 SELECT x.id_,
    x.data_pubblicazione,
    x.data_inizio,
    x.data_fine,
    x.titolo,
    x.assetentryid,
    x.fileuuid,
    x.pdf,
    x.link,
    COALESCE((x.data_inizio)::timestamp without time zone, x.data_pubblicazione) AS data_sort
   FROM ( SELECT j.id_,
            j.createdate AS data_pubblicazione,
            ("substring"(j.content, '.*?name="DataInizioEvento".*?CDATA\[(.*?)\].*'::text))::date AS data_inizio,
            ("substring"(j.content, '.*?name="DataFineEvento".*?CDATA\[(.*?)\].*'::text))::date AS data_fine,
            "substring"(a.title, '.*<Title language-id="it_IT">(.*?)<.*'::text) AS titolo,
            a.entryid AS assetentryid,
            "substring"(j.content, '.*"uuid":"(.*?)".*'::text) AS fileuuid,
            ((((('/documents/'::text || f.repositoryid) || f.treepath) || (f.filename)::text) || '/'::text) || (f.uuid_)::text) AS pdf,
            ('/archivio-report-post-evento/-/asset_publisher/HpRwtPMIzgmZ/content/id/'::text || a.entryid) AS link
           FROM ((public.journalarticle j
             LEFT JOIN public.assetentry a ON (((a.classtypeid = '57636'::bigint) AND (a.classpk = ((j.articleid)::bigint + 2)))))
             LEFT JOIN public.dlfileentry f ON (((f.uuid_)::text = "substring"(j.content, '.*"uuid":"(.*?)".*'::text))))
          WHERE (((j.ddmstructurekey)::text = '57635'::text) AND (j.version = ( SELECT max(j2.version) AS max
                   FROM public.journalarticle j2
                  WHERE ((j2.articleid)::text = (j.articleid)::text))))
          ORDER BY j.createdate DESC) x;


--
-- TOC entry 646 (class 1259 OID 109041648)
-- Name: sensori_comuni_tutti_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.sensori_comuni_tutti_vw AS
 SELECT s.id_,
    s.name,
    sv.idvariabile,
    s.namebasin,
    s.namesubbasin,
    (s.attivo AND ((now() - (sv.dataultimovalore)::timestamp with time zone) < '3 days'::interval)) AS attivo,
    array_to_string(array_agg(DISTINCT replace((o2.nome)::text, 'Comune '::text, ''::text)), ', '::text) AS comuni,
    (('_'::text || array_to_string(array_agg(DISTINCT o2.id_gruppo), '_'::text)) || '_'::text) AS idcomuni,
    COALESCE(sv3.idvariabile, sv2.idvariabile) AS idvariabilevera,
    (NOT (EXISTS ( SELECT d.idstazione,
            d.idvariabile
           FROM public.bollettino_disattivazionesensore d
          WHERE (((d.idstazione)::text = (s.id_)::text) AND ((d.idvariabile)::text = (sv.idvariabile)::text))))) AS funzionante,
    i.sogliaspike,
    sv.soglia1,
    sv.soglia2,
    sv.soglia3
   FROM ((((((((((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile sv ON (((s.id_)::text = (sv.idstazione)::text)))
     LEFT JOIN public.bollettino_regolaallarmecondizione c2 ON ((((s.id_)::text = (c2.idstazione)::text) AND ((sv.idvariabile)::text = (c2.idvariabile)::text) AND (c2.id_ = ( SELECT min(rac2.id_) AS min
           FROM public.bollettino_regolaallarmecondizione rac2
          WHERE (rac2.idregola = c2.idregola))))))
     LEFT JOIN public.bollettino_regolaallarme ra ON ((ra.id_ = c2.idregola)))
     LEFT JOIN public.bollettino_idrometro i ON ((((i.stazioneid)::text = (c2.idstazione)::text) AND ((c2.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text))))
     LEFT JOIN public.bollettino_pluviometro p ON ((((p.stazioneid)::text = (c2.idstazione)::text) AND ((c2.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))))
     LEFT JOIN public.rubrica_rubricagruppo o ON ((((o.nome)::text = (COALESCE(i.nomerubrica, p.nomerubrica))::text) AND (o.fk_sito_proprietario = 20181))))
     LEFT JOIN public.rubrica_rubricagruppogruppi uo ON ((uo.fk_gruppo_padre = o.id_gruppo)))
     LEFT JOIN public.rubrica_rubricagruppo o2 ON (((o2.id_gruppo = uo.fk_gruppo_figlio) AND (((o2.nome)::text ~~ 'Comune%'::text) OR ((o2.nome)::text ~~ 'Unione%'::text)))))
     LEFT JOIN public.bollettino_stazionevariabile sv2 ON ((((s.id_)::text = (sv2.idstazione)::text) AND ((sv.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND ((sv2.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text))))
     LEFT JOIN public.bollettino_stazionevariabile sv3 ON ((((s.id_)::text = (sv3.idstazione)::text) AND ((sv.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND ((sv3.idvariabile)::text = '1,0,900/1,-,-,-/B13011'::text))))
  WHERE ((sv.idvariabile)::text = ANY (ARRAY[('254,0,0/1,-,-,-/B13215'::character varying)::text, ('1,0,3600/1,-,-,-/B13011'::character varying)::text]))
  GROUP BY s.id_, s.name, sv.idvariabile, s.namebasin, s.namesubbasin, s.attivo, sv2.idvariabile, sv3.idvariabile, i.sogliaspike, sv.dataultimovalore, sv.soglia1, sv.soglia2, sv.soglia3
  ORDER BY sv.idvariabile DESC, s.name;


--
-- TOC entry 534 (class 1259 OID 693660)
-- Name: sms_by_month_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.sms_by_month_vw AS
 SELECT (((date_part('month'::text, allerter_sms.datainvio))::text || '/'::text) || (date_part('year'::text, allerter_sms.datainvio))::text) AS mese,
    count(*) AS numero_sms,
    count(
        CASE
            WHEN ((allerter_sms.tipo)::text = 'allerta'::text) THEN 1
            ELSE NULL::integer
        END) AS numero_sms_allerta,
    count(
        CASE
            WHEN ((allerter_sms.tipo)::text = 'monitoraggio'::text) THEN 1
            ELSE NULL::integer
        END) AS numero_sms_monitoraggio,
    count(
        CASE
            WHEN ((allerter_sms.tipo)::text = 'superamento'::text) THEN 1
            ELSE NULL::integer
        END) AS numero_sms_superamento,
    count(
        CASE
            WHEN (allerter_sms.stato = 5) THEN 1
            ELSE NULL::integer
        END) AS numero_invii_falliti,
    avg((allerter_sms.dataricevuta - allerter_sms.datainvio)) AS media_tempo_consegna
   FROM public.allerter_sms
  GROUP BY (((date_part('month'::text, allerter_sms.datainvio))::text || '/'::text) || (date_part('year'::text, allerter_sms.datainvio))::text)
  ORDER BY (((date_part('month'::text, allerter_sms.datainvio))::text || '/'::text) || (date_part('year'::text, allerter_sms.datainvio))::text);


--
-- TOC entry 535 (class 1259 OID 693665)
-- Name: sms_dettaglio_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.sms_dettaglio_vw AS
 SELECT
        CASE
            WHEN ((s.tipo)::text = 'superamento'::text) THEN (((s.tipo)::text || '_'::text) || s.param)
            ELSE (((s.tipo)::text || '_'::text) || (s.sottotipo)::text)
        END AS id,
    s.nomedestinatario,
    s.numero,
    s.stato,
        CASE
            WHEN (s.stato = 0) THEN 'In preparazione'::text
            WHEN (s.stato = 1) THEN 'Pronto per spedizione'::text
            WHEN (s.stato = 2) THEN 'In spedizione'::text
            WHEN (s.stato = 3) THEN 'Spedito'::text
            WHEN (s.stato = 4) THEN 'Invio riuscito'::text
            WHEN (s.stato = 5) THEN 'Invio FALLITO'::text
            WHEN (s.stato = 6) THEN 'Richiesta notifica in corso'::text
            WHEN (s.stato = 7) THEN 'Notifica consegna non ricevuta'::text
            WHEN (s.stato = '-1000'::integer) THEN 'Duplicato'::text
            WHEN (s.stato = '-1001'::integer) THEN 'Duplicato (invio riuscito)'::text
            WHEN (s.stato = '-1002'::integer) THEN 'Duplicato (invio FALLITO)'::text
            ELSE NULL::text
        END AS nomestato,
    s.testo,
    s.datainvio,
    s.dataack,
    s.dataricevuta,
    s.tentativi,
    (EXISTS ( SELECT s2.id_,
            s2.tipo,
            s2.sottotipo,
            s2.param,
            s2.testo,
            s2.destinatario,
            s2.numeroda,
            s2.numero,
            s2.nomedestinatario,
            s2.stato,
            s2.datainvio,
            s2.dataack,
            s2.dataricevuta,
            s2.tentativi,
            s2.prossimoinvio,
            s2.codiceerrore,
            s2.descrizioneerrore,
            s2."timestamp"
           FROM public.allerter_sms s2
          WHERE (((s2.tipo)::text = (s.tipo)::text) AND (((s.tipo)::text = 'superamento'::text) OR ((s2.sottotipo)::text = (s.sottotipo)::text)) AND (s2.param = s.param) AND ((s2.numero)::text = (s.numero)::text) AND (s2.stato = ANY (ARRAY[(4)::bigint, ('-1001'::integer)::bigint]))))) AS contatto_ricevuto,
    (EXISTS ( SELECT s2.id_,
            s2.tipo,
            s2.sottotipo,
            s2.param,
            s2.testo,
            s2.destinatario,
            s2.numeroda,
            s2.numero,
            s2.nomedestinatario,
            s2.stato,
            s2.datainvio,
            s2.dataack,
            s2.dataricevuta,
            s2.tentativi,
            s2.prossimoinvio,
            s2.codiceerrore,
            s2.descrizioneerrore,
            s2."timestamp"
           FROM public.allerter_sms s2
          WHERE (((s2.tipo)::text = (s.tipo)::text) AND (((s.tipo)::text = 'superamento'::text) OR ((s2.sottotipo)::text = (s.sottotipo)::text)) AND (s2.param = s.param) AND ((s2.numero)::text IN ( SELECT s3.numero
                   FROM public.allerter_sms s3
                  WHERE (((s3.tipo)::text = (s.tipo)::text) AND ((s3.sottotipo)::text = (s.sottotipo)::text) AND (s3.param = s.param) AND (s3.destinatario = s.destinatario)))) AND (s2.stato = ANY (ARRAY[(4)::bigint, ('-1001'::integer)::bigint]))))) AS destinatario_ricevuto,
    s.destinatario AS id_destinatario
   FROM public.allerter_sms s
  ORDER BY
        CASE
            WHEN ((s.tipo)::text = 'superamento'::text) THEN (((s.tipo)::text || '_'::text) || s.param)
            ELSE (((s.tipo)::text || '_'::text) || (s.sottotipo)::text)
        END, s.nomedestinatario, s.numero;


--
-- TOC entry 536 (class 1259 OID 693670)
-- Name: sms_invii_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.sms_invii_vw AS
 SELECT x.id,
    x.evento,
    x.tipo_evento,
    x.generati,
    x.spediti,
    x.consegnati,
    x.successo,
    x.ultimo_aggiornamento,
    x.creazione
   FROM (( SELECT (((s.tipo)::text || '_'::text) || s.param) AS id,
                CASE
                    WHEN ((r.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) THEN ((('Soglia '::text || r.soglia) || ' '::text) || (st.name)::text)
                    ELSE (('Soglia '::text ||
                    CASE
                        WHEN (r.soglia = 1) THEN (sv.soglia1 || 'mm/h '::text)
                        WHEN (r.soglia = 2) THEN (sv.soglia2 || 'mm/3h '::text)
                        WHEN (r.soglia = 3) THEN (sv.soglia3 || 'mm/12h '::text)
                        ELSE NULL::text
                    END) || (st.name)::text)
                END AS evento,
                CASE
                    WHEN ((r.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) THEN 'Superamento idrometrico'::text
                    ELSE 'Superamento pluviometrico'::text
                END AS tipo_evento,
            count(*) AS generati,
            count(
                CASE
                    WHEN ((s.dataack IS NOT NULL) OR (s.stato = 5)) THEN 1
                    ELSE NULL::integer
                END) AS spediti,
            count(
                CASE
                    WHEN (s.stato = 4) THEN s.dataricevuta
                    ELSE NULL::timestamp without time zone
                END) AS consegnati,
            ((100.0 * (count(
                CASE
                    WHEN (s.stato = 4) THEN s.dataricevuta
                    ELSE NULL::timestamp without time zone
                END))::numeric) / (count(*))::numeric) AS successo,
            GREATEST(max(s.dataricevuta), max(s.dataack), max(s.datainvio)) AS ultimo_aggiornamento,
            min(s.datainvio) AS creazione
           FROM ((((public.allerter_sms s
             JOIN public.bollettino_allarme a ON ((s.param = a.allarmeid)))
             JOIN public.bollettino_regolaallarmecondizione r ON (((r.idregola = a.idregola) AND (r.id_ = ( SELECT min(r2.id_) AS min
                   FROM public.bollettino_regolaallarmecondizione r2
                  WHERE (r2.idregola = r.idregola))))))
             JOIN public.bollettino_stazione st ON (((st.id_)::text = (r.idstazione)::text)))
             LEFT JOIN public.bollettino_stazionevariabile sv ON ((((r.idstazione)::text = (sv.idstazione)::text) AND ((r.idvariabile)::text = (sv.idvariabile)::text))))
          WHERE (((s.tipo)::text = 'superamento'::text) AND (s.stato >= 0))
          GROUP BY s.tipo, s.param, r.idvariabile, r.soglia, st.name, sv.soglia1, sv.soglia2, sv.soglia3
          ORDER BY s.tipo, s.param)
        UNION
         SELECT (((s.tipo)::text || '_'::text) || (s.sottotipo)::text) AS id,
                CASE
                    WHEN ((s.tipo)::text = 'allerta'::text) THEN ('Allerta n. '::text || (s.sottotipo)::text)
                    WHEN ((s.tipo)::text = 'monitoraggio'::text) THEN ('Monitoraggio '::text || (s.sottotipo)::text)
                    WHEN ((s.tipo)::text = 'comunicazione'::text) THEN 'Comunicazione'::text
                    WHEN ((s.tipo)::text = 'valanghe'::text) THEN ('Allerta valanghe n. '::text || (s.sottotipo)::text)
                    ELSE NULL::text
                END AS evento,
                CASE
                    WHEN ((s.tipo)::text = 'allerta'::text) THEN 'Allerta PC'::text
                    WHEN ((s.tipo)::text = 'monitoraggio'::text) THEN 'Documento monitoraggio'::text
                    WHEN ((s.tipo)::text = 'comunicazione'::text) THEN 'Comunicazione'::text
                    WHEN ((s.tipo)::text = 'valanghe'::text) THEN 'Allerta valanghe'::text
                    ELSE NULL::text
                END AS tipo_evento,
            count(*) AS generati,
            count(
                CASE
                    WHEN ((s.dataack IS NOT NULL) OR (s.stato = 5)) THEN 1
                    ELSE NULL::integer
                END) AS spediti,
            count(
                CASE
                    WHEN (s.stato = 4) THEN s.dataricevuta
                    ELSE NULL::timestamp without time zone
                END) AS consegnati,
            ((100.0 * (count(
                CASE
                    WHEN (s.stato = 4) THEN s.dataricevuta
                    ELSE NULL::timestamp without time zone
                END))::numeric) / (count(*))::numeric) AS successo,
            GREATEST(max(s.dataricevuta), max(s.dataack), max(s.datainvio)) AS ultimo_aggiornamento,
            min(s.datainvio) AS creazione
           FROM public.allerter_sms s
          WHERE (((s.tipo)::text = ANY (ARRAY[('allerta'::character varying)::text, ('monitoraggio'::character varying)::text, ('comunicazione'::character varying)::text, ('valanghe'::character varying)::text])) AND (s.stato >= 0))
          GROUP BY s.tipo, s.sottotipo) x
  ORDER BY x.creazione DESC;


--
-- TOC entry 553 (class 1259 OID 693738)
-- Name: ultimi_due_valori_sensori; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.ultimi_due_valori_sensori AS
 SELECT v.idstazione,
    v.idvariabile,
    v.dataultimovalore,
    ( SELECT s.datetime
           FROM public.bollettino_valoresensore s
          WHERE (((s.idstazione)::text = (v.idstazione)::text) AND ((s.idvariabile)::text = (v.idvariabile)::text))
          ORDER BY s.datetime DESC
         OFFSET 1
         LIMIT 1) AS datapenultimovalore
   FROM public.bollettino_stazionevariabile v;


--
-- TOC entry 554 (class 1259 OID 693742)
-- Name: spike_idrometri; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.spike_idrometri AS
 SELECT COALESCE(i.nomerubrica, staz.name) AS nomerubrica,
    u.idstazione,
    u.idvariabile,
    v.value AS ult,
    v2.value AS penult,
    (v.value - v2.value) AS delta,
    i.sogliaspike
   FROM ((((public.ultimi_due_valori_sensori u
     JOIN public.bollettino_idrometro i ON (((i.stazioneid)::text = (u.idstazione)::text)))
     JOIN public.bollettino_valoresensore v ON ((((v.idstazione)::text = (u.idstazione)::text) AND ((v.idvariabile)::text = (u.idvariabile)::text) AND (v.datetime = u.dataultimovalore))))
     JOIN public.bollettino_valoresensore v2 ON ((((v2.idstazione)::text = (u.idstazione)::text) AND ((v2.idvariabile)::text = (u.idvariabile)::text) AND (v2.datetime = u.datapenultimovalore))))
     LEFT JOIN public.bollettino_stazione staz ON (((staz.id_)::text = (u.idstazione)::text)))
  WHERE (((u.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) AND ((v.value - v2.value) > i.sogliaspike) AND (i.sogliaspike > (0.0)::double precision));


--
-- TOC entry 612 (class 1259 OID 8626119)
-- Name: superamenti_soglia1_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.superamenti_soglia1_vw AS
 SELECT bv.uuid_,
    bv.id_,
    bv.value,
    bv.datetime,
    bv.idvariabile,
    bv.idstazione,
    sv.soglia1
   FROM ((( SELECT bollettino_valoresensore.idstazione,
            max(bollettino_valoresensore.datetime) AS datetime
           FROM public.bollettino_valoresensore
          WHERE ((bollettino_valoresensore.idvariabile)::text ~~ '%13215%'::text)
          GROUP BY bollettino_valoresensore.idstazione) x
     JOIN public.bollettino_valoresensore bv ON ((((bv.idstazione)::text = (x.idstazione)::text) AND (bv.datetime = x.datetime) AND ((bv.idvariabile)::text ~~ '%13215%'::text))))
     JOIN public.bollettino_stazionevariabile sv ON ((((sv.idstazione)::text = (bv.idstazione)::text) AND ((sv.idvariabile)::text = (bv.idvariabile)::text))))
  WHERE ((bv.value >= sv.soglia1) AND (sv.soglia1 <> (0)::double precision));


--
-- TOC entry 643 (class 1259 OID 93767254)
-- Name: utenti_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.utenti_vw AS
SELECT
    NULL::bigint AS userid,
    NULL::character varying(75) AS screenname,
    NULL::character varying(75) AS lastname,
    NULL::character varying(75) AS firstname,
    NULL::character varying(254) AS emailaddress,
    NULL::text AS ruoli_portale,
    NULL::text AS servizio,
    NULL::text AS ruolo_in_modulo;



--
-- TOC entry 636 (class 1259 OID 66015672)
-- Name: verifica_correttezza_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.verifica_correttezza_vw AS
 SELECT x.allertaid,
    x.dataemissione,
    x.datainizio,
    date_part('dow'::text, x.datainizio) AS dow,
    vd1.datoinserito AS c1,
    vd2.datoinserito AS c2,
    vd3.datoinserito AS c3,
    vd4.datoinserito AS c4,
    vd5.datoinserito AS c5,
    vd6.datoinserito AS c6,
    vd7.datoinserito AS c7,
    vd8.datoinserito AS c8,
    vd9.datoinserito AS c9
   FROM (((((((((( SELECT a.allertaid,
            a.dataemissione,
            a.datainizio
           FROM public.allerter_allerta a
          WHERE (a.stato = 0)
        UNION
         SELECT a.allertaid,
            a.dataemissione,
            (a.datainizio + '12:00:00'::interval) AS datainizio
           FROM public.allerter_allerta a
          WHERE ((a.stato = 0) AND (date_part('hour'::text, a.datainizio) = (12)::double precision))
        UNION
         SELECT a.allertaid,
            a.dataemissione,
            (a.datafine - '24:00:00'::interval) AS datainizio
           FROM public.allerter_allerta a
          WHERE ((a.stato = 0) AND ((a.datafine - a.datainizio) >= '2 days'::interval))
        UNION
         SELECT a.allertaid,
            a.dataemissione,
            (a.datafine - '48:00:00'::interval) AS datainizio
           FROM public.allerter_allerta a
          WHERE ((a.stato = 0) AND ((a.datafine - a.datainizio) >= '3 days'::interval))) x
     LEFT JOIN public.verifica_verificadato vd1 ON (((vd1.documento = x.allertaid) AND (vd1.giorno = x.datainizio) AND (vd1.evento = 1) AND ((vd1.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd2 ON (((vd2.documento = x.allertaid) AND (vd2.giorno = x.datainizio) AND (vd2.evento = 2) AND ((vd2.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd3 ON (((vd3.documento = x.allertaid) AND (vd3.giorno = x.datainizio) AND (vd3.evento = 3) AND ((vd3.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd4 ON (((vd4.documento = x.allertaid) AND (vd4.giorno = x.datainizio) AND (vd4.evento = 4) AND ((vd4.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd5 ON (((vd5.documento = x.allertaid) AND (vd5.giorno = x.datainizio) AND (vd5.evento = 5) AND ((vd5.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd6 ON (((vd6.documento = x.allertaid) AND (vd6.giorno = x.datainizio) AND (vd6.evento = 6) AND ((vd6.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd7 ON (((vd7.documento = x.allertaid) AND (vd7.giorno = x.datainizio) AND (vd7.evento = 7) AND ((vd7.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd8 ON (((vd8.documento = x.allertaid) AND (vd8.giorno = x.datainizio) AND (vd8.evento = 8) AND ((vd8.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd9 ON (((vd9.documento = x.allertaid) AND (vd9.giorno = x.datainizio) AND (vd9.evento = 9) AND ((vd9.nomedato)::text = 'correttezza'::text))))
  ORDER BY x.datainizio, x.dataemissione;


--
-- TOC entry 647 (class 1259 OID 109058657)
-- Name: verifica_settimanale_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.verifica_settimanale_vw AS
 SELECT ((('Report settimanale dal '::text || to_char((((('now'::text)::date + i.i) - 7))::timestamp with time zone, 'dd/MM/yyyy'::text)) || ' al '::text) || to_char((((('now'::text)::date + i.i) - 0))::timestamp with time zone, 'dd/MM/yyyy'::text)) AS titolo,
    ((('Report settimanale dal '::text || to_char((((('now'::text)::date + i.i) - 7))::timestamp with time zone, 'dd/MM/yyyy'::text)) || ' al '::text) || to_char((((('now'::text)::date + i.i) - 0))::timestamp with time zone, 'dd/MM/yyyy'::text)) AS subtitle,
    ('/verifica?p_p_id=allerta_verifica_web_AllertaVerificaWebPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_allerta_verifica_web_AllertaVerificaWebPortlet_mvcRenderCommandName=%2Fallertaer%2Fverifica%2Fcompila&_allerta_verifica_web_AllertaVerificaWebPortlet_id='::text || ( SELECT min(verifica_verifica.id_) AS min
           FROM public.verifica_verifica
          WHERE (verifica_verifica.datainizio >= ((('now'::text)::date + i.i) - 7)))) AS text,
    to_char(((('now'::text)::date + i.i))::timestamp with time zone, 'DD/MM/YYYY HH24:MI'::text) AS dataemissione,
    to_char((((('now'::text)::date + i.i) - 7))::timestamp with time zone, 'DD/MM/YYYY HH24:MI'::text) AS datainizio,
    'icon i-info-circle-o'::text AS cls,
    ('/o/report/verifica-settimana?datada='::text || to_char((((('now'::text)::date + i.i) - 7))::timestamp with time zone, 'dd/MM/yyyy'::text)) AS pdf,
    ((('now'::text)::date + i.i) - 7) AS datainiziovera
   FROM generate_series(('2022-01-10'::date - ('now'::text)::date), 0) i(i)
  WHERE (date_part('dow'::text, (('now'::text)::date + i.i)) = (1)::double precision);

--
-- TOC entry 7400 (class 2618 OID 93767257)
-- Name: utenti_vw _RETURN; Type: RULE; Schema: public; Owner: -
--

CREATE OR REPLACE VIEW public.utenti_vw AS
 SELECT user_.userid,
    user_.screenname,
    user_.lastname,
    user_.firstname,
    user_.emailaddress,
    string_agg((r.name)::text, ', '::text) AS ruoli_portale,
    ev.data_ AS servizio,
    ev2.data_ AS ruolo_in_modulo
   FROM (((((public.user_
     LEFT JOIN public.users_roles ON ((user_.userid = users_roles.userid)))
     JOIN public.role_ r ON (((r.roleid = users_roles.roleid) AND ((r.name)::text <> 'User'::text))))
     LEFT JOIN public.expandorow er ON ((er.classpk = user_.userid)))
     LEFT JOIN public.expandovalue ev ON (((ev.columnid = 79996) AND (ev.rowid_ = er.rowid_))))
     LEFT JOIN public.expandovalue ev2 ON (((ev2.columnid = 36341) AND (ev2.rowid_ = er.rowid_))))
  WHERE ((user_.status = 0) AND (user_.userid <> 20158))
  GROUP BY user_.userid, ev.data_, ev2.data_
  ORDER BY user_.lastname, user_.firstname;



--
-- TOC entry 637 (class 1259 OID 66015677)
-- Name: verifica_valutazione_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.verifica_valutazione_vw AS
 SELECT x.allertaid,
    x.dataemissione,
    x.datainizio,
    x.fenomeno,
    vd1.datoinserito AS correttezza,
    vd2.datoinserito AS magnitudo,
    vd3.datoinserito AS localizzazione,
    vd4.datoinserito AS cause,
    vd5.datoinserito AS valutazione_descrittiva
   FROM (((((( SELECT DISTINCT v.allertaid,
            v.dataemissione,
            v.datainizio,
            generate_series.generate_series AS fenomeno
           FROM (public.verifica_correttezza_vw v
             JOIN generate_series(1, 9) generate_series(generate_series) ON ((1 = 1)))
          WHERE ((EXISTS ( SELECT a.allertastatoid
                   FROM public.allerter_allertastato a
                  WHERE ((a.allertaid = v.allertaid) AND (a.eventoid = generate_series.generate_series) AND (a.statoid > 0) AND (a.statoid <> 1000) AND ((a.areaid *
                        CASE
                            WHEN (date_part('hour'::text, v.datainizio) = (12)::double precision) THEN '-1'::integer
                            ELSE 1
                        END) > 0)))) OR (EXISTS ( SELECT vv.id_
                   FROM public.verifica_verificadato vv
                  WHERE ((vv.documento = v.allertaid) AND (vv.giorno = v.datainizio) AND (vv.evento = generate_series.generate_series) AND ((vv.nomedato)::text = 'colore_post'::text) AND (vv.datoinserito = ANY (ARRAY['GIALLO'::text, 'ARANCIONE'::text, 'ROSSO'::text]))))))
          ORDER BY v.datainizio, generate_series.generate_series) x
     LEFT JOIN public.verifica_verificadato vd1 ON (((vd1.documento = x.allertaid) AND (vd1.giorno = x.datainizio) AND (vd1.evento = x.fenomeno) AND ((vd1.nomedato)::text = 'correttezza'::text))))
     LEFT JOIN public.verifica_verificadato vd2 ON (((vd2.documento = x.allertaid) AND (vd2.giorno = x.datainizio) AND (vd2.evento = x.fenomeno) AND ((vd2.nomedato)::text = 'magnitudo'::text))))
     LEFT JOIN public.verifica_verificadato vd3 ON (((vd3.documento = x.allertaid) AND (vd3.giorno = x.datainizio) AND (vd3.evento = x.fenomeno) AND ((vd3.nomedato)::text = 'localizzazione'::text))))
     LEFT JOIN public.verifica_verificadato vd4 ON (((vd4.documento = x.allertaid) AND (vd4.giorno = x.datainizio) AND (vd4.evento = x.fenomeno) AND ((vd4.nomedato)::text = 'cause'::text))))
     LEFT JOIN public.verifica_verificadato vd5 ON (((vd5.documento = x.allertaid) AND (vd5.giorno = x.datainizio) AND (vd5.evento = x.fenomeno) AND ((vd5.nomedato)::text = 'valutazione_descrittiva'::text))));


--
-- TOC entry 583 (class 1259 OID 693879)
-- Name: view_staz_sens; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.view_staz_sens AS
 SELECT vs.datetime,
    staz.id_,
    vs.value,
    staz.lat,
    staz.lon,
    staz.name,
    stazvar.idvariabile
   FROM ((public.bollettino_stazionevariabile stazvar
     JOIN public.bollettino_stazione staz ON (((stazvar.idstazione)::text = (staz.id_)::text)))
     LEFT JOIN public.bollettino_valoresensore vs ON (((vs.idstazione)::text = (staz.id_)::text)))
  WHERE (staz.attivo AND (stazvar.dataultimovalore IS NOT NULL) AND ((now() - (stazvar.dataultimovalore)::timestamp with time zone) < '5 days'::interval));


--
-- TOC entry 584 (class 1259 OID 693884)
-- Name: view_staz_sensore_15m; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.view_staz_sensore_15m AS
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM (public.bollettino_stazionevariabile
     JOIN public.bollettino_stazione s ON (((bollettino_stazionevariabile.idstazione)::text = (s.id_)::text)))
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND (NOT ((bollettino_stazionevariabile.idstazione)::text IN ( SELECT bollettino_stazionevariabile_1.idstazione
           FROM public.bollettino_stazionevariabile bollettino_stazionevariabile_1
          WHERE ((bollettino_stazionevariabile_1.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text)))) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL) AND s.attivo AND ((now() - (bollettino_stazionevariabile.dataultimovalore)::timestamp with time zone) < '5 days'::interval))
UNION
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM (public.bollettino_stazionevariabile
     JOIN public.bollettino_stazione s ON (((bollettino_stazionevariabile.idstazione)::text = (s.id_)::text)))
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text) AND (NOT ((bollettino_stazionevariabile.idstazione)::text IN ( SELECT bollettino_stazionevariabile_1.idstazione
           FROM public.bollettino_stazionevariabile bollettino_stazionevariabile_1
          WHERE ((bollettino_stazionevariabile_1.idvariabile)::text = '1,0,900/1,-,-,-/B13011'::text)))) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL) AND s.attivo AND ((now() - (bollettino_stazionevariabile.dataultimovalore)::timestamp with time zone) < '5 days'::interval))
UNION
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM (public.bollettino_stazionevariabile
     JOIN public.bollettino_stazione s ON (((bollettino_stazionevariabile.idstazione)::text = (s.id_)::text)))
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,900/1,-,-,-/B13011'::text) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL) AND s.attivo AND ((now() - (bollettino_stazionevariabile.dataultimovalore)::timestamp with time zone) < '5 days'::interval));


--
-- TOC entry 585 (class 1259 OID 693889)
-- Name: view_staz_sensore_30m; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.view_staz_sensore_30m AS
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM (public.bollettino_stazionevariabile
     JOIN public.bollettino_stazione s ON (((bollettino_stazionevariabile.idstazione)::text = (s.id_)::text)))
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND (NOT ((bollettino_stazionevariabile.idstazione)::text IN ( SELECT bollettino_stazionevariabile_1.idstazione
           FROM public.bollettino_stazionevariabile bollettino_stazionevariabile_1
          WHERE ((bollettino_stazionevariabile_1.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text)))) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL) AND s.attivo AND ((now() - (bollettino_stazionevariabile.dataultimovalore)::timestamp with time zone) < '5 days'::interval))
UNION
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM (public.bollettino_stazionevariabile
     JOIN public.bollettino_stazione s ON (((bollettino_stazionevariabile.idstazione)::text = (s.id_)::text)))
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL) AND s.attivo AND ((now() - (bollettino_stazionevariabile.dataultimovalore)::timestamp with time zone) < '5 days'::interval));



--
-- TOC entry 587 (class 1259 OID 693898)
-- Name: visualizzazioni_allerta_vw; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.visualizzazioni_allerta_vw AS
 SELECT a.allertaid,
    a.datainizio,
    a.datafine,
    a.numero,
    a.tipoallerta AS allerta,
    a.titolo,
    f.title AS file,
    a.link,
    f.readcount
   FROM (public.dlfileentry f
     JOIN public.allerter_allerta a ON (((a.link)::text ~~ (('%/'::text || f.folderid) || '/%'::text))))
  WHERE ((a.stato = 0) AND (((f.title)::text ~~ 'allerta%'::text) OR ((f.title)::text ~~ 'bollettino%'::text)))
  ORDER BY a.datainizio;


--
-- TOC entry 588 (class 1259 OID 693903)
-- Name: vw_soglie_idro; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.vw_soglie_idro AS
 SELECT x.name,
    x.idstazione,
    x.idvariabile,
    x.dataultimovalore,
    x.soglia1,
    x.soglia2,
    x.soglia3,
    x.valore,
    ((x.soglia1 <> (0)::double precision) AND (x.valore >= x.soglia1)) AS superamento1,
    ((x.soglia2 <> (0)::double precision) AND (x.valore >= x.soglia2)) AS superamento2,
    ((x.soglia3 <> (0)::double precision) AND (x.valore >= x.soglia3)) AS superamento3
   FROM ( SELECT s.name,
            sv.idstazione,
            sv.idvariabile,
            sv.dataultimovalore,
            sv.soglia1,
            sv.soglia2,
            sv.soglia3,
            ( SELECT v.value
                   FROM public.bollettino_valoresensore v
                  WHERE (((v.idstazione)::text = (sv.idstazione)::text) AND ((v.idvariabile)::text = (sv.idvariabile)::text))
                  ORDER BY v.datetime DESC
                 LIMIT 1) AS valore
           FROM (public.bollettino_stazione s
             JOIN public.bollettino_stazionevariabile sv ON (((s.id_)::text = (sv.idstazione)::text)))
          WHERE (((sv.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) AND (NOT (EXISTS ( SELECT spike.valore
                   FROM public.allerter_logspike spike
                  WHERE (((spike.idstazione)::text = (sv.idstazione)::text) AND (spike.dataora = sv.dataultimovalore))))) AND (NOT (EXISTS ( SELECT d.idstazione,
                    d.idvariabile
                   FROM public.bollettino_disattivazionesensore d
                  WHERE (((d.idstazione)::text = (sv.idstazione)::text) AND ((d.idvariabile)::text = (sv.idvariabile)::text))))) AND s.attivo)) x;


--
-- TOC entry 589 (class 1259 OID 693908)
-- Name: vw_soglie_pluvio; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.vw_soglie_pluvio AS
 SELECT z.idstazione,
    z.name,
    z.soglia1,
    z.soglia2,
    z.soglia3,
    z.v_1h,
    z.v_3h,
    z.v_12h,
    COALESCE(((z.soglia1 > (0)::double precision) AND (z.v_1h >= z.soglia1)), false) AS superamento1,
    COALESCE(((z.soglia2 > (0)::double precision) AND (z.v_3h >= z.soglia2)), false) AS superamento2,
    COALESCE(((z.soglia3 > (0)::double precision) AND (z.v_12h >= z.soglia3)), false) AS superamento3
   FROM ( SELECT y.id_ AS idstazione,
            y.name,
            y.soglia1,
            y.soglia2,
            y.soglia3,
            GREATEST(y.v1_1h, y.v1_30min, y.v1_15min) AS v_1h,
            GREATEST(y.v2_1h, y.v2_30min, (y.v2_15min)::double precision) AS v_3h,
            GREATEST(y.v3_1h, (y.v3_30min)::double precision, (y.v3_15min)::double precision) AS v_12h
           FROM ( SELECT x.uuid_,
                    x.id_,
                    x.ident,
                    x.name,
                    x.lon,
                    x.lat,
                    x.height,
                    x.idbasin,
                    x.idsubbasin,
                    x.idcountry,
                    x.idprovince,
                    x.idregion,
                    x.idmunicipality,
                    x.idmacroarea,
                    x.namebasin,
                    x.namesubbasin,
                    x.namecountry,
                    x.nameprovince,
                    x.nameregion,
                    x.namemunicipality,
                    x.namemacroarea,
                    x.network,
                    x.attivo,
                    x.incluso,
                    x.progressivo,
                    sv.soglia1,
                    sv.soglia2,
                    sv.soglia3,
                    ( SELECT sum(tmp.value) AS sum
                           FROM ( SELECT v.value
                                   FROM public.bollettino_valoresensore v
                                  WHERE (((v.idstazione)::text = (x.id_)::text) AND ((v.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))
                                  ORDER BY v.datetime DESC
                                 LIMIT 1) tmp) AS v1_1h,
                    ( SELECT sum(tmp.value) AS sum
                           FROM ( SELECT v.value
                                   FROM public.bollettino_valoresensore v
                                  WHERE (((v.idstazione)::text = (x.id_)::text) AND ((v.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text))
                                  ORDER BY v.datetime DESC
                                 LIMIT 2) tmp) AS v1_30min,
                    ( SELECT sum(tmp.value) AS sum
                           FROM ( SELECT v.value
                                   FROM public.bollettino_valoresensore v
                                  WHERE (((v.idstazione)::text = (x.id_)::text) AND ((v.idvariabile)::text = '1,0,900/1,-,-,-/B13011'::text))
                                  ORDER BY v.datetime DESC
                                 LIMIT 4) tmp) AS v1_15min,
                    ( SELECT sum(tmp.value) AS sum
                           FROM ( SELECT v.value
                                   FROM public.bollettino_valoresensore v
                                  WHERE (((v.idstazione)::text = (x.id_)::text) AND ((v.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))
                                  ORDER BY v.datetime DESC
                                 LIMIT 3) tmp) AS v2_1h,
                    ( SELECT sum(tmp.value) AS sum
                           FROM ( SELECT v.value
                                   FROM public.bollettino_valoresensore v
                                  WHERE (((v.idstazione)::text = (x.id_)::text) AND ((v.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text))
                                  ORDER BY v.datetime DESC
                                 LIMIT 6) tmp) AS v2_30min,
                    '-1'::integer AS v2_15min,
                    ( SELECT sum(tmp.value) AS sum
                           FROM ( SELECT v.value
                                   FROM public.bollettino_valoresensore v
                                  WHERE (((v.idstazione)::text = (x.id_)::text) AND ((v.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))
                                  ORDER BY v.datetime DESC
                                 LIMIT 12) tmp) AS v3_1h,
                    '-1'::integer AS v3_30min,
                    '-1'::integer AS v3_15min
                   FROM (( SELECT s.uuid_,
                            s.id_,
                            s.ident,
                            s.name,
                            s.lon,
                            s.lat,
                            s.height,
                            s.idbasin,
                            s.idsubbasin,
                            s.idcountry,
                            s.idprovince,
                            s.idregion,
                            s.idmunicipality,
                            s.idmacroarea,
                            s.namebasin,
                            s.namesubbasin,
                            s.namecountry,
                            s.nameprovince,
                            s.nameregion,
                            s.namemunicipality,
                            s.namemacroarea,
                            s.network,
                            s.attivo,
                            s.incluso,
                            s.progressivo
                           FROM public.bollettino_stazione s
                          WHERE (s.attivo AND (EXISTS ( SELECT sv_1.uuid_,
                                    sv_1.id_,
                                    sv_1.idstazione,
                                    sv_1.idvariabile,
                                    sv_1.dataultimovalore,
                                    sv_1.soglia1,
                                    sv_1.soglia2,
                                    sv_1.soglia3
                                   FROM public.bollettino_stazionevariabile sv_1
                                  WHERE (((sv_1.idstazione)::text = (s.id_)::text) AND ((sv_1.idvariabile)::text ~~ '%B13011'::text)))) AND (NOT (EXISTS ( SELECT d.idstazione,
                                    d.idvariabile
                                   FROM public.bollettino_disattivazionesensore d
                                  WHERE (((d.idstazione)::text = (s.id_)::text) AND ((d.idvariabile)::text ~~ '%B13011'::text))))))) x
                     LEFT JOIN public.bollettino_stazionevariabile sv ON ((((sv.idstazione)::text = (x.id_)::text) AND ((sv.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))))) y) z;


--
-- TOC entry 622 (class 1259 OID 53711246)
-- Name: vw_attivazione_monitoraggio; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.vw_attivazione_monitoraggio AS
 SELECT i.dataultimovalore AS datasup,
    i.name AS nome_idro,
    i.soglia1 AS soglia_idro,
    i.valore AS valore_idro,
    pl.name AS nome_pluvio,
    pl.soglia3 AS soglia_pluvio,
    pl.v_12h AS valore_pluvio
   FROM ((((public.bollettino_regolaallarmecondizione rac
     JOIN public.bollettino_regolaallarme ra ON ((ra.id_ = rac.idregola)))
     JOIN public.bollettino_regolaallarmecondizione rac2 ON (((rac2.idregola = rac.idregola) AND (rac2.id_ <> rac.id_))))
     JOIN public.vw_soglie_idro i ON ((((i.idstazione)::text = (rac.idstazione)::text) AND i.superamento1)))
     JOIN public.vw_soglie_pluvio pl ON ((((pl.idstazione)::text = (rac2.idstazione)::text) AND pl.superamento3)))
  WHERE (((rac.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) AND (i.soglia1 <> (0.0)::double precision) AND ra.attivo);


--
-- TOC entry 590 (class 1259 OID 693913)
-- Name: vw_stato_regole; Type: VIEW; Schema: public; Owner: -
--

CREATE VIEW public.vw_stato_regole AS
 SELECT z.idregola,
    z.nome,
    z.espressione,
    z.descrizione,
    z.colore,
    z.idcondizione,
    z.lettera,
    z.soglia,
    z.idstazione,
    z.soglia1,
    z.soglia2,
    z.soglia3,
    z.v1,
    z.v2,
    z.v3,
    z.superamento1,
    z.superamento2,
    z.superamento3,
    z.tipo,
    (((z.tipo = 'pluvio'::text) OR (EXISTS ( SELECT bollettino_bollettinoparametro.parametroid,
            bollettino_bollettinoparametro.valore
           FROM public.bollettino_bollettinoparametro
          WHERE (((bollettino_bollettinoparametro.parametroid)::text = 'GESTIONE_MONITORAGGIO'::text) AND (bollettino_bollettinoparametro.valore = 'true'::text))))) AND ((z.superamento1 AND (z.soglia = 1)) OR (z.superamento2 AND (z.soglia = 2)) OR (z.superamento3 AND (z.soglia = 3)))) AS superata
   FROM ( SELECT ra.id_ AS idregola,
            ra.nome,
            ra.espressione,
            ra.descrizione,
            ra.colore,
            rac.id_ AS idcondizione,
            rac.lettera,
            rac.soglia,
            x.idstazione,
            x.soglia1,
            x.soglia2,
            x.soglia3,
            x.v1,
            x.v2,
            x.v3,
            x.superamento1,
            x.superamento2,
            x.superamento3,
            x.tipo
           FROM ((public.bollettino_regolaallarme ra
             JOIN public.bollettino_regolaallarmecondizione rac ON ((rac.idregola = ra.id_)))
             LEFT JOIN ( SELECT i.idstazione,
                    i.soglia1,
                    i.soglia2,
                    i.soglia3,
                    i.valore AS v1,
                    i.valore AS v2,
                    i.valore AS v3,
                    i.superamento1,
                    i.superamento2,
                    i.superamento3,
                    'idro'::text AS tipo
                   FROM public.vw_soglie_idro i
                UNION
                 SELECT p.idstazione,
                    p.soglia1,
                    p.soglia2,
                    p.soglia3,
                    p.v_1h AS v1,
                    p.v_3h AS v2,
                    p.v_12h AS v3,
                    p.superamento1,
                    p.superamento2,
                    p.superamento3,
                    'pluvio'::text AS tipo
                   FROM public.vw_soglie_pluvio p) x ON ((((rac.idstazione)::text = (x.idstazione)::text) AND ((((rac.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) AND (x.tipo = 'idro'::text)) OR (((rac.idvariabile)::text <> '254,0,0/1,-,-,-/B13215'::text) AND (x.tipo = 'pluvio'::text))))))) z;
