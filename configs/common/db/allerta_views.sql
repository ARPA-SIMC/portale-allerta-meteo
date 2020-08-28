--
-- PostgreSQL database dump
--

-- Dumped from database version 10.8 (Ubuntu 10.8-1.pgdg18.04+1)
-- Dumped by pg_dump version 10.8 (Ubuntu 10.8-1.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: area_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_rubrica_vw AS
 SELECT DISTINCT a.nome AS area,
    u.firstname,
    u.lastname,
    u.userid
   FROM (((public.organization_ o
     JOIN public.users_orgs uo ON ((o.organizationid = uo.organizationid)))
     JOIN public.user_ u ON ((u.userid = uo.userid)))
     JOIN public.allerter_area a ON ((((o.name)::text = ('Allerta Zona '::text || (a.nome)::text)) OR ((o.name)::text IN ( SELECT ('Allerta Zona '::text || (o2.nome)::text)
           FROM public.allerter_area o2
          WHERE ((o2.tipoarea)::text = (a.nome)::text))) OR ((o.name)::text = ('Allerta Zona '::text || (( SELECT ar.tipoarea
           FROM public.allerter_area ar
          WHERE ((ar.nome)::text = (a.nome)::text)))::text)))))
  WHERE (u.status = 0)
  ORDER BY a.nome;


ALTER TABLE public.area_rubrica_vw OWNER TO usrweballerte;

--
-- Name: area_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_email_vw AS
( SELECT v.area,
    v.firstname,
    v.lastname,
    u.emailaddress AS valore
   FROM ((public.area_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.user_ u ON ((u.userid = v.userid)))
  ORDER BY v.area, v.firstname, v.lastname, u.emailaddress)
UNION
( SELECT v.area,
    v.firstname,
    v.lastname,
    a.address AS valore
   FROM ((public.area_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.emailaddress a ON ((a.classpk = c.contactid)))
  ORDER BY v.area, v.firstname, v.lastname, a.address);


ALTER TABLE public.area_email_vw OWNER TO usrweballerte;

--
-- Name: area_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_numeri_vw AS
 SELECT v.area,
    v.firstname,
    v.lastname,
    p.number_ AS valore
   FROM ((public.area_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.phone p ON ((p.classpk = c.contactid)))
  ORDER BY v.area, v.firstname, v.lastname, p.number_;


ALTER TABLE public.area_numeri_vw OWNER TO usrweballerte;

--
-- Name: area_contatti_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_contatti_vw AS
 SELECT area_numeri_vw.area,
    regexp_replace(((((((area_numeri_vw.firstname)::text || ' '::text) || (area_numeri_vw.lastname)::text) || '";"'::text) || (area_numeri_vw.valore)::text) || '";"SMS'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.area_numeri_vw
UNION
 SELECT area_email_vw.area,
    regexp_replace(((((((area_email_vw.firstname)::text || ' '::text) || (area_email_vw.lastname)::text) || '";"'::text) || (area_email_vw.valore)::text) || '";"EMAIL'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.area_email_vw;


ALTER TABLE public.area_contatti_vw OWNER TO usrweballerte;

--
-- Name: area_contatti_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_contatti_vw_2 AS
 SELECT area_numeri_vw.area,
    regexp_replace((((area_numeri_vw.firstname)::text || ' '::text) || (area_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (area_numeri_vw.valore)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.area_numeri_vw
UNION
 SELECT area_email_vw.area,
    regexp_replace((((area_email_vw.firstname)::text || ' '::text) || (area_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (area_email_vw.valore)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.area_email_vw;


ALTER TABLE public.area_contatti_vw_2 OWNER TO usrweballerte;

--
-- Name: area_email_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_email_vw_2 AS
( SELECT u.uuid_ AS uuid,
    v.area,
    v.firstname,
    v.lastname,
    u.emailaddress AS valore
   FROM ((public.area_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.user_ u ON ((u.userid = v.userid)))
  ORDER BY v.area, v.firstname, v.lastname, u.emailaddress)
UNION
( SELECT a.uuid_ AS uuid,
    v.area,
    v.firstname,
    v.lastname,
    a.address AS valore
   FROM ((public.area_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.emailaddress a ON ((a.classpk = c.contactid)))
  ORDER BY v.area, v.firstname, v.lastname, a.address);


ALTER TABLE public.area_email_vw_2 OWNER TO usrweballerte;

--
-- Name: area_numeri_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_numeri_vw_2 AS
 SELECT p.uuid_ AS uuid,
    v.area,
    v.firstname,
    v.lastname,
    p.number_ AS valore
   FROM ((public.area_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.phone p ON ((p.classpk = c.contactid)))
  ORDER BY v.area, v.firstname, v.lastname, p.number_;


ALTER TABLE public.area_numeri_vw_2 OWNER TO usrweballerte;

--
-- Name: area_contatti_vw_3; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_contatti_vw_3 AS
 SELECT area_numeri_vw_2.uuid AS id,
    area_numeri_vw_2.area AS tag,
    regexp_replace(((((((area_numeri_vw_2.firstname)::text || ' '::text) || (area_numeri_vw_2.lastname)::text) || '";"'::text) || (area_numeri_vw_2.valore)::text) || '";"SMS'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.area_numeri_vw_2
UNION
 SELECT area_email_vw_2.uuid AS id,
    area_email_vw_2.area AS tag,
    regexp_replace(((((((area_email_vw_2.firstname)::text || ' '::text) || (area_email_vw_2.lastname)::text) || '";"'::text) || (area_email_vw_2.valore)::text) || '";"EMAIL'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.area_email_vw_2;


ALTER TABLE public.area_contatti_vw_3 OWNER TO usrweballerte;

--
-- Name: area_contatti_vw_4; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.area_contatti_vw_4 AS
 SELECT area_numeri_vw_2.uuid AS id,
    (('ZONA '::text || (area_numeri_vw_2.area)::text))::character varying(75) AS tag,
    regexp_replace((((area_numeri_vw_2.firstname)::text || ' '::text) || (area_numeri_vw_2.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (area_numeri_vw_2.valore)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.area_numeri_vw_2
UNION
 SELECT area_email_vw_2.uuid AS id,
    (('ZONA '::text || (area_email_vw_2.area)::text))::character varying(75) AS tag,
    regexp_replace((((area_email_vw_2.firstname)::text || ' '::text) || (area_email_vw_2.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (area_email_vw_2.valore)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.area_email_vw_2;


ALTER TABLE public.area_contatti_vw_4 OWNER TO usrweballerte;

--
-- Name: org_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.org_rubrica_vw AS
 SELECT o.organizationid,
    o.name,
    u.firstname,
    u.lastname,
    u.userid
   FROM ((public.organization_ o
     JOIN public.users_orgs uo ON ((o.organizationid = uo.organizationid)))
     JOIN public.user_ u ON ((u.userid = uo.userid)))
  ORDER BY o.name;


ALTER TABLE public.org_rubrica_vw OWNER TO usrweballerte;

--
-- Name: org_email_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.org_email_vw_2 AS
( SELECT u.uuid_ AS uuid,
    v.organizationid,
    v.name,
    v.firstname,
    v.lastname,
    u.emailaddress AS valore
   FROM ((public.org_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.user_ u ON ((u.userid = v.userid)))
  ORDER BY v.name, v.firstname, v.lastname, u.emailaddress)
UNION
( SELECT a.uuid_ AS uuid,
    v.organizationid,
    v.name,
    v.firstname,
    v.lastname,
    a.address AS valore
   FROM ((public.org_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.emailaddress a ON ((a.classpk = c.contactid)))
  ORDER BY v.name, v.firstname, v.lastname, a.address);


ALTER TABLE public.org_email_vw_2 OWNER TO usrweballerte;

--
-- Name: fiume_email_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.fiume_email_vw_2 AS
 SELECT n.uuid,
    x.name AS fiume,
    o2.name AS gruppoinvio,
    n.firstname,
    n.lastname,
    n.valore AS email,
    ((o2.name)::text !~~ '%-NT'::text) AS tecnico
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 196015) AND ((o.name)::text ~~ 'FIUME%'::text))) x
     JOIN public.organization_ o2 ON (((o2.treepath ~~ (x.treepath || '%/'::text)) OR ((o2.name)::text = ANY (ARRAY[('SEMPRE-NT'::character varying)::text, ('SEMPRE-TT'::character varying)::text])))))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.fiume_email_vw_2 OWNER TO usrweballerte;

--
-- Name: org_numeri_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.org_numeri_vw_2 AS
 SELECT p.uuid_ AS uuid,
    v.organizationid,
    v.name,
    v.firstname,
    v.lastname,
    v.userid,
    p.number_ AS valore
   FROM ((public.org_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.phone p ON ((p.classpk = c.contactid)))
  ORDER BY v.name, v.firstname, v.lastname, p.number_;


ALTER TABLE public.org_numeri_vw_2 OWNER TO usrweballerte;

--
-- Name: fiume_numeri_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.fiume_numeri_vw_2 AS
 SELECT n.uuid,
    x.name AS fiume,
    o2.name AS gruppoinvio,
    n.firstname,
    n.lastname,
    n.valore AS numero,
    ((o2.name)::text !~~ '%-NT'::text) AS tecnico
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 196015) AND ((o.name)::text ~~ 'FIUME%'::text))) x
     JOIN public.organization_ o2 ON (((o2.treepath ~~ (x.treepath || '%/'::text)) OR ((o2.name)::text = ANY (ARRAY[('SEMPRE-NT'::character varying)::text, ('SEMPRE-TT'::character varying)::text])))))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.fiume_numeri_vw_2 OWNER TO usrweballerte;

--
-- Name: bacini_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.bacini_rubrica_vw AS
 SELECT fiume_numeri_vw_2.uuid AS id,
    fiume_numeri_vw_2.fiume AS tag,
    regexp_replace((((fiume_numeri_vw_2.firstname)::text || ' '::text) || (fiume_numeri_vw_2.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (fiume_numeri_vw_2.numero)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.fiume_numeri_vw_2
UNION
 SELECT fiume_email_vw_2.uuid AS id,
    fiume_email_vw_2.fiume AS tag,
    regexp_replace((((fiume_email_vw_2.firstname)::text || ' '::text) || (fiume_email_vw_2.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (fiume_email_vw_2.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.fiume_email_vw_2;


ALTER TABLE public.bacini_rubrica_vw OWNER TO usrweballerte;

--
-- Name: comune_superamento_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.comune_superamento_vw OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_vw AS
 SELECT DISTINCT u.firstname,
    u.lastname,
    u.userid
   FROM ((public.organization_ o
     JOIN public.users_orgs uo ON ((o.organizationid = uo.organizationid)))
     JOIN public.user_ u ON ((u.userid = uo.userid)))
  WHERE (((o.name)::text = 'Rubrica Allerta'::text) AND (u.status = 0));


ALTER TABLE public.destinatari_sempre_vw OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_email_vw AS
( SELECT v.firstname,
    v.lastname,
    u.emailaddress AS valore
   FROM ((public.destinatari_sempre_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.user_ u ON ((u.userid = v.userid)))
  ORDER BY v.firstname, v.lastname, u.emailaddress)
UNION
( SELECT v.firstname,
    v.lastname,
    a.address AS valore
   FROM ((public.destinatari_sempre_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.emailaddress a ON ((a.classpk = c.contactid)))
  ORDER BY v.firstname, v.lastname, a.address);


ALTER TABLE public.destinatari_sempre_email_vw OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_numeri_vw AS
 SELECT v.firstname,
    v.lastname,
    p.number_ AS valore
   FROM ((public.destinatari_sempre_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.phone p ON ((p.classpk = c.contactid)))
  ORDER BY v.firstname, v.lastname, p.number_;


ALTER TABLE public.destinatari_sempre_numeri_vw OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_contatti_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_contatti_vw AS
 SELECT regexp_replace(((((((destinatari_sempre_numeri_vw.firstname)::text || ' '::text) || (destinatari_sempre_numeri_vw.lastname)::text) || '";"'::text) || (destinatari_sempre_numeri_vw.valore)::text) || '";"SMS'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.destinatari_sempre_numeri_vw
UNION
 SELECT regexp_replace(((((((destinatari_sempre_email_vw.firstname)::text || ' '::text) || (destinatari_sempre_email_vw.lastname)::text) || '";"'::text) || (destinatari_sempre_email_vw.valore)::text) || '";"EMAIL'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.destinatari_sempre_email_vw;


ALTER TABLE public.destinatari_sempre_contatti_vw OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_contatti_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_contatti_vw_2 AS
 SELECT regexp_replace((((destinatari_sempre_numeri_vw.firstname)::text || ' '::text) || (destinatari_sempre_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (destinatari_sempre_numeri_vw.valore)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.destinatari_sempre_numeri_vw
UNION
 SELECT regexp_replace((((destinatari_sempre_email_vw.firstname)::text || ' '::text) || (destinatari_sempre_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (destinatari_sempre_email_vw.valore)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.destinatari_sempre_email_vw;


ALTER TABLE public.destinatari_sempre_contatti_vw_2 OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_email_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_email_vw_2 AS
( SELECT u.uuid_ AS uuid,
    v.firstname,
    v.lastname,
    u.emailaddress AS valore
   FROM ((public.destinatari_sempre_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.user_ u ON ((u.userid = v.userid)))
  ORDER BY v.firstname, v.lastname, u.emailaddress)
UNION
( SELECT a.uuid_ AS uuid,
    v.firstname,
    v.lastname,
    a.address AS valore
   FROM ((public.destinatari_sempre_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.emailaddress a ON ((a.classpk = c.contactid)))
  ORDER BY v.firstname, v.lastname, a.address);


ALTER TABLE public.destinatari_sempre_email_vw_2 OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_numeri_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_numeri_vw_2 AS
 SELECT p.uuid_ AS uuid,
    v.firstname,
    v.lastname,
    p.number_ AS valore
   FROM ((public.destinatari_sempre_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.phone p ON ((p.classpk = c.contactid)))
  ORDER BY v.firstname, v.lastname, p.number_;


ALTER TABLE public.destinatari_sempre_numeri_vw_2 OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_contatti_vw_3; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_contatti_vw_3 AS
 SELECT destinatari_sempre_numeri_vw_2.uuid,
    regexp_replace((((destinatari_sempre_numeri_vw_2.firstname)::text || ' '::text) || (destinatari_sempre_numeri_vw_2.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (destinatari_sempre_numeri_vw_2.valore)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.destinatari_sempre_numeri_vw_2
UNION
 SELECT destinatari_sempre_email_vw_2.uuid,
    regexp_replace((((destinatari_sempre_email_vw_2.firstname)::text || ' '::text) || (destinatari_sempre_email_vw_2.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (destinatari_sempre_email_vw_2.valore)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.destinatari_sempre_email_vw_2;


ALTER TABLE public.destinatari_sempre_contatti_vw_3 OWNER TO usrweballerte;

--
-- Name: destinatari_sempre_contatti_vw_4; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.destinatari_sempre_contatti_vw_4 AS
 SELECT destinatari_sempre_numeri_vw_2.uuid,
    regexp_replace(((((((destinatari_sempre_numeri_vw_2.firstname)::text || ' '::text) || (destinatari_sempre_numeri_vw_2.lastname)::text) || '";"'::text) || (destinatari_sempre_numeri_vw_2.valore)::text) || '";"SMS'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.destinatari_sempre_numeri_vw_2
UNION
 SELECT destinatari_sempre_email_vw_2.uuid,
    regexp_replace(((((((destinatari_sempre_email_vw_2.firstname)::text || ' '::text) || (destinatari_sempre_email_vw_2.lastname)::text) || '";"'::text) || (destinatari_sempre_email_vw_2.valore)::text) || '";"EMAIL'::text), ''''::text, ' '::text, 'g'::text) AS rubrica
   FROM public.destinatari_sempre_email_vw_2;


ALTER TABLE public.destinatari_sempre_contatti_vw_4 OWNER TO usrweballerte;

--
-- Name: org_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.org_email_vw AS
( SELECT v.organizationid,
    v.name,
    v.firstname,
    v.lastname,
    u.emailaddress AS valore
   FROM ((public.org_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.user_ u ON ((u.userid = v.userid)))
  ORDER BY v.name, v.firstname, v.lastname, u.emailaddress)
UNION
( SELECT v.organizationid,
    v.name,
    v.firstname,
    v.lastname,
    a.address AS valore
   FROM ((public.org_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.emailaddress a ON ((a.classpk = c.contactid)))
  ORDER BY v.name, v.firstname, v.lastname, a.address);


ALTER TABLE public.org_email_vw OWNER TO usrweballerte;

--
-- Name: fiume_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.fiume_email_vw AS
 SELECT x.name AS fiume,
    o2.name AS gruppoinvio,
    n.firstname,
    n.lastname,
    n.valore AS email,
    ((o2.name)::text !~~ '%-NT'::text) AS tecnico
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 196015) AND ((o.name)::text ~~ 'FIUME%'::text))) x
     JOIN public.organization_ o2 ON (((o2.treepath ~~ (x.treepath || '%/'::text)) OR ((o2.name)::text = ANY (ARRAY[('SEMPRE-NT'::character varying)::text, ('SEMPRE-TT'::character varying)::text])))))
     JOIN public.org_email_vw n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.fiume_email_vw OWNER TO usrweballerte;

--
-- Name: org_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.org_numeri_vw AS
 SELECT v.organizationid,
    v.name,
    v.firstname,
    v.lastname,
    v.userid,
    p.number_ AS valore
   FROM ((public.org_rubrica_vw v
     JOIN public.contact_ c ON ((v.userid = c.classpk)))
     JOIN public.phone p ON ((p.classpk = c.contactid)))
  ORDER BY v.name, v.firstname, v.lastname, p.number_;


ALTER TABLE public.org_numeri_vw OWNER TO usrweballerte;

--
-- Name: fiume_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.fiume_numeri_vw AS
 SELECT x.name AS fiume,
    o2.name AS gruppoinvio,
    n.firstname,
    n.lastname,
    n.valore AS numero,
    ((o2.name)::text !~~ '%-NT'::text) AS tecnico
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 196015) AND ((o.name)::text ~~ 'FIUME%'::text))) x
     JOIN public.organization_ o2 ON (((o2.treepath ~~ (x.treepath || '%/'::text)) OR ((o2.name)::text = ANY (ARRAY[('SEMPRE-NT'::character varying)::text, ('SEMPRE-TT'::character varying)::text])))))
     JOIN public.org_numeri_vw n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.fiume_numeri_vw OWNER TO usrweballerte;

--
-- Name: meteomont_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.meteomont_email_vw AS
 SELECT n.uuid,
        CASE
            WHEN (n.organizationid = 238662) THEN 'Meteomont_App_Emilia_Centrale'::text
            WHEN (n.organizationid = 238668) THEN 'Meteomont_App_Emilia_Occidentale'::text
            ELSE 'Meteomont_App_Romagnolo'::text
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 238646) AND ((o.name)::text ~~ 'Valanghe %'::text) AND (o.organizationid <> 515378))) x
     JOIN public.organization_ o2 ON (((o2.organizationid = x.organizationid) OR (x.organizationid = 515378))))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.meteomont_email_vw OWNER TO usrweballerte;

--
-- Name: meteomont_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.meteomont_numeri_vw AS
 SELECT n.uuid,
        CASE
            WHEN (n.organizationid = 238662) THEN 'Meteomont_App_Emilia_Centrale'::text
            WHEN (n.organizationid = 238668) THEN 'Meteomont_App_Emilia_Occidentale'::text
            ELSE 'Meteomont_App_Romagnolo'::text
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS numero
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 238646) AND ((o.name)::text ~~ 'Valanghe %'::text) AND (o.organizationid <> 515378))) x
     JOIN public.organization_ o2 ON (((o2.organizationid = x.organizationid) OR (x.organizationid = 515378))))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.meteomont_numeri_vw OWNER TO usrweballerte;

--
-- Name: meteomont_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.meteomont_rubrica_vw AS
 SELECT meteomont_numeri_vw.uuid AS id,
    meteomont_numeri_vw.tag,
    regexp_replace((((meteomont_numeri_vw.firstname)::text || ' '::text) || (meteomont_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (meteomont_numeri_vw.numero)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.meteomont_numeri_vw
UNION
 SELECT meteomont_email_vw.uuid AS id,
    meteomont_email_vw.tag,
    regexp_replace((((meteomont_email_vw.firstname)::text || ' '::text) || (meteomont_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (meteomont_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.meteomont_email_vw;


ALTER TABLE public.meteomont_rubrica_vw OWNER TO usrweballerte;

--
-- Name: meteomont_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--
/*----- FROM IMPORT
CREATE VIEW public.meteomont_vw AS
 SELECT (( SELECT regexp_matches(j.title, '.+<Title language-id="it_IT">(.+)</Title>.+'::text) AS regexp_matches))[1] AS titolo,
    ('/documents'::text || (( SELECT regexp_matches(j.content, '.+<!\[CDATA\[/documents(.+)\]\]>.+'::text) AS regexp_matches))[1]) AS url
   FROM public.journalarticle j
  WHERE (((j.structureid)::text = '227847'::text) AND (j.modifieddate = ( SELECT max(j2.modifieddate) AS max
           FROM public.journalarticle j2
          WHERE ((j2.articleid)::text = (j.articleid)::text))))
  ORDER BY j.createdate DESC;
 -----*/
 
 
CREATE VIEW public.meteomont_vw AS
SELECT JournalArticleLocalization.title AS titolo,
(
	select '/documents'::text || '/' || j.groupid::text || '/' || folderid::text || '/' || title::text || '/' || uuid_::text
	from public.dlfileentry where uuid_= (
		 select (
			select
			regexp_matches(
				xpath('/root/dynamic-element[@type=''document_library'']/dynamic-content/text()', content::xml)::text
			, 'uuid\\":\\"(.+)\\"}.+'::text) AS regexp_matches	 
				)[1]
	 )
) as url	
FROM public.journalarticle j
    inner join public.journalarticlelocalization
		on j.id_ = JournalArticleLocalization.articlepk
		and  j.defaultlanguageid = JournalArticleLocalization.languageid
WHERE 
	(j.ddmstructurekey)::text = '227847'::text 
	 AND (
	   j.modifieddate = ( 
		   SELECT max(j2.modifieddate) AS max
		   FROM public.journalarticle j2
		   WHERE (j2.articleid)::text = (j.articleid)::text)
	   )
ORDER BY j.createdate DESC;  


ALTER TABLE public.meteomont_vw OWNER TO usrweballerte;

--
-- Name: monit_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.monit_vw OWNER TO usrweballerte;

--
-- Name: monitoraggio_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.monitoraggio_email_vw AS
 SELECT n.uuid,
    replace((x.name)::text, 'Monitoraggio '::text, 'Monitoraggio_Fiume_'::text) AS tag,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 233088) AND ((o.name)::text ~~ 'Monitoraggio %'::text))) x
     JOIN public.organization_ o2 ON (((o2.organizationid = x.organizationid) OR (x.organizationid = 233088))))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.monitoraggio_email_vw OWNER TO usrweballerte;

--
-- Name: monitoraggio_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.monitoraggio_numeri_vw AS
 SELECT n.uuid,
    replace((x.name)::text, 'Monitoraggio '::text, 'Monitoraggio_Fiume_'::text) AS tag,
    n.firstname,
    n.lastname,
    n.valore AS numero
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 233088) AND ((o.name)::text ~~ 'Monitoraggio %'::text))) x
     JOIN public.organization_ o2 ON (((o2.organizationid = x.organizationid) OR (x.organizationid = 233088))))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.monitoraggio_numeri_vw OWNER TO usrweballerte;

--
-- Name: monitoraggio_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.monitoraggio_rubrica_vw AS
 SELECT monitoraggio_numeri_vw.uuid AS id,
    monitoraggio_numeri_vw.tag,
    regexp_replace((((monitoraggio_numeri_vw.firstname)::text || ' '::text) || (monitoraggio_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (monitoraggio_numeri_vw.numero)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.monitoraggio_numeri_vw
UNION
 SELECT monitoraggio_email_vw.uuid AS id,
    monitoraggio_email_vw.tag,
    regexp_replace((((monitoraggio_email_vw.firstname)::text || ' '::text) || (monitoraggio_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (monitoraggio_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.monitoraggio_email_vw;


ALTER TABLE public.monitoraggio_rubrica_vw OWNER TO usrweballerte;

--
-- Name: new_area_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_area_rubrica_vw AS
 SELECT area_contatti_vw_4.id,
    area_contatti_vw_4.tag,
    area_contatti_vw_4.nome,
    area_contatti_vw_4.recapito,
    area_contatti_vw_4.tipo
   FROM public.area_contatti_vw_4
UNION
 SELECT destinatari_sempre_contatti_vw_3.uuid AS id,
    'ZONE_SEMPRE'::character varying AS tag,
    destinatari_sempre_contatti_vw_3.nome,
    destinatari_sempre_contatti_vw_3.recapito,
    destinatari_sempre_contatti_vw_3.tipo
   FROM public.destinatari_sempre_contatti_vw_3;


ALTER TABLE public.new_area_rubrica_vw OWNER TO usrweballerte;

--
-- Name: new_fiume_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_fiume_email_vw AS
( SELECT DISTINCT n.uuid,
        CASE
            WHEN (((o2.name)::text ~~ 'IDR.%'::text) OR ((o2.name)::text ~~ '%-TT'::text)) THEN ((x.name)::text || '-TT'::text)
            ELSE ((x.name)::text || '-NT'::text)
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 196015) AND ((o.name)::text ~~ 'FIUME%'::text))) x
     JOIN public.organization_ o2 ON ((o2.treepath ~~ (x.treepath || '%/'::text))))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY n.lastname, n.firstname)
UNION
 SELECT n.uuid,
    ('FIUME_'::text || (o2.name)::text) AS tag,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM (public.organization_ o2
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  WHERE ((o2.name)::text = ANY (ARRAY[('SEMPRE-NT'::character varying)::text, ('SEMPRE-TT'::character varying)::text]));


ALTER TABLE public.new_fiume_email_vw OWNER TO usrweballerte;

--
-- Name: new_fiume_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_fiume_numeri_vw AS
( SELECT DISTINCT n.uuid,
        CASE
            WHEN (((o2.name)::text ~~ 'IDR.%'::text) OR ((o2.name)::text ~~ '%-TT'::text)) THEN ((x.name)::text || '-TT'::text)
            ELSE ((x.name)::text || '-NT'::text)
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS numero
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 196015) AND ((o.name)::text ~~ 'FIUME%'::text))) x
     JOIN public.organization_ o2 ON ((o2.treepath ~~ (x.treepath || '%/'::text))))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY n.lastname, n.firstname)
UNION
 SELECT n.uuid,
    ('FIUME_'::text || (o2.name)::text) AS tag,
    n.firstname,
    n.lastname,
    n.valore AS numero
   FROM (public.organization_ o2
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  WHERE ((o2.name)::text = ANY (ARRAY[('SEMPRE-NT'::character varying)::text, ('SEMPRE-TT'::character varying)::text]));


ALTER TABLE public.new_fiume_numeri_vw OWNER TO usrweballerte;

--
-- Name: new_fiume_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_fiume_rubrica_vw AS
 SELECT new_fiume_numeri_vw.uuid AS id,
    new_fiume_numeri_vw.tag,
    regexp_replace((((new_fiume_numeri_vw.firstname)::text || ' '::text) || (new_fiume_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_fiume_numeri_vw.numero)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.new_fiume_numeri_vw
UNION
 SELECT new_fiume_email_vw.uuid AS id,
    new_fiume_email_vw.tag,
    regexp_replace((((new_fiume_email_vw.firstname)::text || ' '::text) || (new_fiume_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_fiume_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.new_fiume_email_vw;


ALTER TABLE public.new_fiume_rubrica_vw OWNER TO usrweballerte;

--
-- Name: new_meteomont_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_meteomont_email_vw AS
 SELECT n.uuid,
        CASE
            WHEN (n.organizationid = 238662) THEN 'Meteomont_App_Emilia_Centrale'::text
            WHEN (n.organizationid = 238668) THEN 'Meteomont_App_Emilia_Occidentale'::text
            WHEN (n.organizationid = 515378) THEN 'Meteomont_sempre'::text
            ELSE 'Meteomont_App_Romagnolo'::text
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 238646) AND ((o.name)::text ~~ 'Valanghe %'::text))) x
     JOIN public.organization_ o2 ON ((o2.organizationid = x.organizationid)))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.new_meteomont_email_vw OWNER TO usrweballerte;

--
-- Name: new_meteomont_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_meteomont_numeri_vw AS
 SELECT n.uuid,
        CASE
            WHEN (n.organizationid = 238662) THEN 'Meteomont_App_Emilia_Centrale'::text
            WHEN (n.organizationid = 238668) THEN 'Meteomont_App_Emilia_Occidentale'::text
            WHEN (n.organizationid = 515378) THEN 'Meteomont_sempre'::text
            ELSE 'Meteomont_App_Romagnolo'::text
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS numero
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE ((o.parentorganizationid = 238646) AND ((o.name)::text ~~ 'Valanghe %'::text))) x
     JOIN public.organization_ o2 ON ((o2.organizationid = x.organizationid)))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.new_meteomont_numeri_vw OWNER TO usrweballerte;

--
-- Name: new_meteomont_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_meteomont_rubrica_vw AS
 SELECT new_meteomont_numeri_vw.uuid AS id,
    new_meteomont_numeri_vw.tag,
    regexp_replace((((new_meteomont_numeri_vw.firstname)::text || ' '::text) || (new_meteomont_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_meteomont_numeri_vw.numero)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.new_meteomont_numeri_vw
UNION
 SELECT new_meteomont_email_vw.uuid AS id,
    new_meteomont_email_vw.tag,
    regexp_replace((((new_meteomont_email_vw.firstname)::text || ' '::text) || (new_meteomont_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_meteomont_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.new_meteomont_email_vw;


ALTER TABLE public.new_meteomont_rubrica_vw OWNER TO usrweballerte;

--
-- Name: new_monitoraggio_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_monitoraggio_email_vw AS
 SELECT n.uuid,
        CASE
            WHEN (x.organizationid = 233088) THEN 'Monitoraggio_sempre'::text
            ELSE replace((x.name)::text, 'Monitoraggio '::text, 'Monitoraggio_Fiume_'::text)
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE (((o.parentorganizationid = 233088) AND ((o.name)::text ~~ 'Monitoraggio %'::text)) OR (o.organizationid = 233088))) x
     JOIN public.organization_ o2 ON ((o2.organizationid = x.organizationid)))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.new_monitoraggio_email_vw OWNER TO usrweballerte;

--
-- Name: new_monitoraggio_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_monitoraggio_numeri_vw AS
 SELECT n.uuid,
        CASE
            WHEN (x.organizationid = 233088) THEN 'Monitoraggio_sempre'::text
            ELSE replace((x.name)::text, 'Monitoraggio '::text, 'Monitoraggio_Fiume_'::text)
        END AS tag,
    n.firstname,
    n.lastname,
    n.valore AS numero
   FROM ((( SELECT o.organizationid,
            o.name,
            o.treepath
           FROM public.organization_ o
          WHERE (((o.parentorganizationid = 233088) AND ((o.name)::text ~~ 'Monitoraggio %'::text)) OR (o.organizationid = 233088))) x
     JOIN public.organization_ o2 ON ((o2.organizationid = x.organizationid)))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = o2.organizationid)))
  ORDER BY x.name, o2.name, n.lastname, n.firstname;


ALTER TABLE public.new_monitoraggio_numeri_vw OWNER TO usrweballerte;

--
-- Name: new_monitoraggio_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_monitoraggio_rubrica_vw AS
 SELECT new_monitoraggio_numeri_vw.uuid AS id,
    new_monitoraggio_numeri_vw.tag,
    regexp_replace((((new_monitoraggio_numeri_vw.firstname)::text || ' '::text) || (new_monitoraggio_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_monitoraggio_numeri_vw.numero)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.new_monitoraggio_numeri_vw
UNION
 SELECT new_monitoraggio_email_vw.uuid AS id,
    new_monitoraggio_email_vw.tag,
    regexp_replace((((new_monitoraggio_email_vw.firstname)::text || ' '::text) || (new_monitoraggio_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_monitoraggio_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.new_monitoraggio_email_vw;


ALTER TABLE public.new_monitoraggio_rubrica_vw OWNER TO usrweballerte;

--
-- Name: new_pluviometro_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_pluviometro_email_vw AS
 SELECT n.uuid,
    p.nomerubrica,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((( SELECT x.nomerubrica
           FROM public.bollettino_pluviometro x
        UNION
         SELECT 'PLV. SEMPRE'::character varying AS nomerubrica) p
     JOIN public.organization_ g ON ((((p.nomerubrica)::text = (g.name)::text) OR (((p.nomerubrica)::text = 'PLV. SEMPRE'::text) AND ((g.name)::text = 'Pluviometri'::text)))))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = g.organizationid)))
  WHERE ((p.nomerubrica IS NOT NULL) AND ((p.nomerubrica)::text <> ''::text))
  ORDER BY p.nomerubrica, n.lastname, n.firstname;


ALTER TABLE public.new_pluviometro_email_vw OWNER TO usrweballerte;

--
-- Name: new_pluviometro_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_pluviometro_numeri_vw AS
 SELECT n.uuid,
    p.nomerubrica,
    n.firstname,
    n.lastname,
    n.valore AS sms
   FROM ((( SELECT x.nomerubrica
           FROM public.bollettino_pluviometro x
        UNION
         SELECT 'PLV. SEMPRE'::character varying AS nomerubrica) p
     JOIN public.organization_ g ON ((((p.nomerubrica)::text = (g.name)::text) OR (((p.nomerubrica)::text = 'PLV. SEMPRE'::text) AND ((g.name)::text = 'Pluviometri'::text)))))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = g.organizationid)))
  WHERE ((p.nomerubrica IS NOT NULL) AND ((p.nomerubrica)::text <> ''::text))
  ORDER BY p.nomerubrica, n.lastname, n.firstname;


ALTER TABLE public.new_pluviometro_numeri_vw OWNER TO usrweballerte;

--
-- Name: new_pluviometro_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.new_pluviometro_rubrica_vw AS
 SELECT new_pluviometro_numeri_vw.uuid AS id,
    new_pluviometro_numeri_vw.nomerubrica AS tag,
    regexp_replace((((new_pluviometro_numeri_vw.firstname)::text || ' '::text) || (new_pluviometro_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_pluviometro_numeri_vw.sms)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.new_pluviometro_numeri_vw
UNION
 SELECT new_pluviometro_email_vw.uuid AS id,
    new_pluviometro_email_vw.nomerubrica AS tag,
    regexp_replace((((new_pluviometro_email_vw.firstname)::text || ' '::text) || (new_pluviometro_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (new_pluviometro_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.new_pluviometro_email_vw;


ALTER TABLE public.new_pluviometro_rubrica_vw OWNER TO usrweballerte;

--
-- Name: pluviometro_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.pluviometro_email_vw AS
 SELECT n.uuid,
    p.nomerubrica,
    n.firstname,
    n.lastname,
    n.valore AS email
   FROM ((public.bollettino_pluviometro p
     JOIN public.organization_ g ON ((((p.nomerubrica)::text = (g.name)::text) OR ((g.name)::text = 'Pluviometri'::text))))
     JOIN public.org_email_vw_2 n ON ((n.organizationid = g.organizationid)))
  WHERE ((p.nomerubrica IS NOT NULL) AND ((p.nomerubrica)::text <> ''::text))
  ORDER BY p.nomerubrica, n.lastname, n.firstname;


ALTER TABLE public.pluviometro_email_vw OWNER TO usrweballerte;

--
-- Name: pluviometro_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.pluviometro_numeri_vw AS
 SELECT n.uuid,
    p.nomerubrica,
    n.firstname,
    n.lastname,
    n.valore AS sms
   FROM ((public.bollettino_pluviometro p
     JOIN public.organization_ g ON ((((p.nomerubrica)::text = (g.name)::text) OR ((g.name)::text = 'Pluviometri'::text))))
     JOIN public.org_numeri_vw_2 n ON ((n.organizationid = g.organizationid)))
  WHERE ((p.nomerubrica IS NOT NULL) AND ((p.nomerubrica)::text <> ''::text))
  ORDER BY p.nomerubrica, n.lastname, n.firstname;


ALTER TABLE public.pluviometro_numeri_vw OWNER TO usrweballerte;

--
-- Name: pluviometro_rubrica_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.pluviometro_rubrica_vw AS
 SELECT pluviometro_numeri_vw.uuid AS id,
    pluviometro_numeri_vw.nomerubrica AS tag,
    regexp_replace((((pluviometro_numeri_vw.firstname)::text || ' '::text) || (pluviometro_numeri_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (pluviometro_numeri_vw.sms)::text AS recapito,
    'SMS'::text AS tipo
   FROM public.pluviometro_numeri_vw
UNION
 SELECT pluviometro_email_vw.uuid AS id,
    pluviometro_email_vw.nomerubrica AS tag,
    regexp_replace((((pluviometro_email_vw.firstname)::text || ' '::text) || (pluviometro_email_vw.lastname)::text), ''''::text, ' '::text, 'g'::text) AS nome,
    (pluviometro_email_vw.email)::text AS recapito,
    'EMAIL'::text AS tipo
   FROM public.pluviometro_email_vw;


ALTER TABLE public.pluviometro_rubrica_vw OWNER TO usrweballerte;

--
-- Name: recapiti_agenzia_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.recapiti_agenzia_vw AS
 SELECT (((b.firstname)::text || '  '::text) || (b.lastname)::text) AS chi,
    b.valore AS recapito,
    'SMS'::text AS sms
   FROM public.destinatari_sempre_numeri_vw_2 b
  WHERE ((b.firstname)::text ~~ '%Agenzia%'::text)
UNION
 SELECT (((c.firstname)::text || '  '::text) || (c.lastname)::text) AS chi,
    c.valore AS recapito,
    'EMAIL'::text AS sms
   FROM public.destinatari_sempre_email_vw_2 c
  WHERE ((c.firstname)::text ~~ '%Agenzia%'::text)
UNION
 SELECT (((a.firstname)::text || '  '::text) || (a.lastname)::text) AS chi,
    a.valore AS recapito,
    'SMS'::text AS sms
   FROM public.area_numeri_vw_2 a
  WHERE ((a.firstname)::text ~~ '%Agenzia%'::text)
UNION
 SELECT (((d.firstname)::text || '  '::text) || (d.lastname)::text) AS chi,
    d.valore AS recapito,
    'EMAIL'::text AS sms
   FROM public.area_email_vw_2 d
  WHERE ((d.firstname)::text ~~ '%Agenzia%'::text)
  ORDER BY 1;


ALTER TABLE public.recapiti_agenzia_vw OWNER TO usrweballerte;

--
-- Name: recapiti_comuni_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.recapiti_comuni_vw AS
 SELECT (((a.firstname)::text || '  '::text) || (a.lastname)::text) AS chi,
    a.valore AS recapito,
    'SMS'::text AS sms
   FROM public.area_numeri_vw_2 a
  WHERE ((a.firstname)::text ~~ '%Comune%'::text)
UNION
 SELECT (((d.firstname)::text || '  '::text) || (d.lastname)::text) AS chi,
    d.valore AS recapito,
    'EMAIL'::text AS sms
   FROM public.area_email_vw_2 d
  WHERE ((d.firstname)::text ~~ '%Comune%'::text)
UNION
 SELECT (((a.firstname)::text || '  '::text) || (a.lastname)::text) AS chi,
    a.valore AS recapito,
    'SMS'::text AS sms
   FROM public.area_numeri_vw_2 a
  WHERE ((a.firstname)::text ~~ '%Unione%'::text)
UNION
 SELECT (((d.firstname)::text || '  '::text) || (d.lastname)::text) AS chi,
    d.valore AS recapito,
    'EMAIL'::text AS sms
   FROM public.area_email_vw_2 d
  WHERE ((d.firstname)::text ~~ '%Unione%'::text)
UNION
 SELECT (((b.firstname)::text || '  '::text) || (b.lastname)::text) AS chi,
    b.valore AS recapito,
    'SMS'::text AS sms
   FROM public.destinatari_sempre_numeri_vw_2 b
  WHERE ((b.firstname)::text ~~ '%Agenzia%'::text)
UNION
 SELECT (((c.firstname)::text || '  '::text) || (c.lastname)::text) AS chi,
    c.valore AS recapito,
    'EMAIL'::text AS sms
   FROM public.destinatari_sempre_email_vw_2 c
  WHERE ((c.firstname)::text ~~ '%Agenzia%'::text)
  ORDER BY 1;


ALTER TABLE public.recapiti_comuni_vw OWNER TO usrweballerte;

--
-- Name: regole_condizioni_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.regole_condizioni_vw OWNER TO usrweballerte;

--
-- Name: regole_allarme_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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
    array_to_string(array_agg(gr.name), ', '::text) AS comuni
   FROM (((((public.regole_condizioni_vw v
     JOIN ( SELECT v3.id_,
            min(v3.idcondizione) AS primaria
           FROM public.regole_condizioni_vw v3
          GROUP BY v3.id_
          ORDER BY v3.id_) v2 ON (((v.id_ = v2.id_) AND (v.idcondizione = v2.primaria))))
     LEFT JOIN public.organization_ o ON (((o.name)::text = (v.nomerubrica)::text)))
     LEFT JOIN public.users_orgs uo ON ((o.organizationid = uo.organizationid)))
     LEFT JOIN public.usergrouprole ugr ON ((uo.userid = ugr.userid)))
     LEFT JOIN public.group_ gr ON (((ugr.groupid = gr.groupid) AND (ugr.roleid = 451351))))
  GROUP BY v.id_, v.nome, v.descrizione, v.idvariabile, v.colore, v.attivo, v.nomerubrica
  ORDER BY v.id_;


ALTER TABLE public.regole_allarme_vw OWNER TO usrweballerte;

--
-- Name: sensori_comuni_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.sensori_comuni_vw AS
 SELECT s.id_,
    s.name,
    sv.idvariabile,
    s.namebasin,
    s.namesubbasin,
    (s.attivo AND ((now() - (sv.dataultimovalore)::timestamp with time zone) < '3 days'::interval)) AS attivo,
    array_to_string(array_agg(DISTINCT g.name), ', '::text) AS comuni,
    (('_'::text || array_to_string(array_agg(DISTINCT g.groupid), '_'::text)) || '_'::text) AS idcomuni,
    sv2.idvariabile AS idvariabilevera,
    (NOT (EXISTS ( SELECT d.idstazione,
            d.idvariabile
           FROM public.bollettino_disattivazionesensore d
          WHERE (((d.idstazione)::text = (s.id_)::text) AND ((d.idvariabile)::text = (sv.idvariabile)::text))))) AS funzionante,
    i.sogliaspike
   FROM ((((((((((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile sv ON (((s.id_)::text = (sv.idstazione)::text)))
     JOIN public.bollettino_regolaallarmecondizione c2 ON ((((s.id_)::text = (c2.idstazione)::text) AND ((sv.idvariabile)::text = (c2.idvariabile)::text) AND (c2.id_ = ( SELECT min(rac2.id_) AS min
           FROM public.bollettino_regolaallarmecondizione rac2
          WHERE (rac2.idregola = c2.idregola))))))
     JOIN public.bollettino_regolaallarme ra ON ((ra.id_ = c2.idregola)))
     LEFT JOIN public.bollettino_idrometro i ON ((((i.stazioneid)::text = (c2.idstazione)::text) AND ((c2.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text))))
     LEFT JOIN public.bollettino_pluviometro p ON ((((p.stazioneid)::text = (c2.idstazione)::text) AND ((c2.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text))))
     LEFT JOIN public.organization_ o ON (((o.name)::text = (COALESCE(i.nomerubrica, p.nomerubrica))::text)))
     LEFT JOIN public.users_orgs uo ON ((uo.organizationid = o.organizationid)))
     LEFT JOIN public.usergrouprole ugr ON (((ugr.userid = uo.userid) AND (ugr.roleid = 451351))))
     LEFT JOIN public.group_ g ON ((g.groupid = ugr.groupid)))
     LEFT JOIN public.bollettino_stazionevariabile sv2 ON ((((s.id_)::text = (sv2.idstazione)::text) AND ((sv.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND ((sv2.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text))))
  WHERE ((sv.idvariabile)::text = ANY (ARRAY[('254,0,0/1,-,-,-/B13215'::character varying)::text, ('1,0,3600/1,-,-,-/B13011'::character varying)::text]))
  GROUP BY s.id_, s.name, sv.idvariabile, s.namebasin, s.namesubbasin, s.attivo, sv2.idvariabile, i.sogliaspike, sv.dataultimovalore
  ORDER BY sv.idvariabile DESC, s.name;


ALTER TABLE public.sensori_comuni_vw OWNER TO usrweballerte;

--
-- Name: sms_by_day_and_type_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.sms_by_day_and_type_vw AS
 SELECT (allerter_sms.datainvio)::date AS datainvio,
    allerter_sms.tipo,
    count(*) AS numero_sms
   FROM public.allerter_sms
  GROUP BY ((allerter_sms.datainvio)::date), allerter_sms.tipo
  ORDER BY ((allerter_sms.datainvio)::date);


ALTER TABLE public.sms_by_day_and_type_vw OWNER TO usrweballerte;

--
-- Name: sms_by_day_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.sms_by_day_vw AS
 SELECT (allerter_sms.datainvio)::date AS datainvio,
    count(*) AS numero_sms
   FROM public.allerter_sms
  GROUP BY ((allerter_sms.datainvio)::date)
  ORDER BY ((allerter_sms.datainvio)::date);


ALTER TABLE public.sms_by_day_vw OWNER TO usrweballerte;

--
-- Name: sms_by_month_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.sms_by_month_vw OWNER TO usrweballerte;

--
-- Name: sms_by_tempo_consegna_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.sms_by_tempo_consegna_vw AS
 SELECT (((date_part('month'::text, allerter_sms.datainvio))::text || '/'::text) || (date_part('year'::text, allerter_sms.datainvio))::text) AS mese,
    ((100.0 * (count(
        CASE
            WHEN ((allerter_sms.dataricevuta - allerter_sms.datainvio) < '00:01:00'::interval) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS minuti1,
    ((100.0 * (count(
        CASE
            WHEN (((allerter_sms.dataricevuta - allerter_sms.datainvio) >= '00:01:00'::interval) AND ((allerter_sms.dataricevuta - allerter_sms.datainvio) < '00:10:00'::interval)) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS minuti10,
    ((100.0 * (count(
        CASE
            WHEN (((allerter_sms.dataricevuta - allerter_sms.datainvio) >= '00:10:00'::interval) AND ((allerter_sms.dataricevuta - allerter_sms.datainvio) < '01:00:00'::interval)) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS ore1,
    ((100.0 * (count(
        CASE
            WHEN (((allerter_sms.dataricevuta - allerter_sms.datainvio) >= '01:00:00'::interval) AND ((allerter_sms.dataricevuta - allerter_sms.datainvio) < '06:00:00'::interval)) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS ore6,
    ((100.0 * (count(
        CASE
            WHEN (((allerter_sms.dataricevuta - allerter_sms.datainvio) >= '06:00:00'::interval) AND ((allerter_sms.dataricevuta - allerter_sms.datainvio) < '12:00:00'::interval)) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS ore12,
    ((100.0 * (count(
        CASE
            WHEN (((allerter_sms.dataricevuta - allerter_sms.datainvio) >= '12:00:00'::interval) AND ((allerter_sms.dataricevuta - allerter_sms.datainvio) < '24:00:00'::interval)) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS ore24,
    ((100.0 * (count(
        CASE
            WHEN ((allerter_sms.dataricevuta - allerter_sms.datainvio) >= '24:00:00'::interval) THEN 1
            ELSE NULL::integer
        END))::numeric) / (count(allerter_sms.dataricevuta))::numeric) AS piudiore24
   FROM public.allerter_sms
  GROUP BY (((date_part('month'::text, allerter_sms.datainvio))::text || '/'::text) || (date_part('year'::text, allerter_sms.datainvio))::text)
  ORDER BY (((date_part('month'::text, allerter_sms.datainvio))::text || '/'::text) || (date_part('year'::text, allerter_sms.datainvio))::text);


ALTER TABLE public.sms_by_tempo_consegna_vw OWNER TO usrweballerte;

--
-- Name: sms_dettaglio_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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
          WHERE (((s2.tipo)::text = (s.tipo)::text) AND ((s2.sottotipo)::text = (s.sottotipo)::text) AND (s2.param = s.param) AND ((s2.numero)::text = (s.numero)::text) AND (s2.stato = ANY (ARRAY[(4)::bigint, ('-1001'::integer)::bigint]))))) AS contatto_ricevuto,
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
          WHERE (((s2.tipo)::text = (s.tipo)::text) AND ((s2.sottotipo)::text = (s.sottotipo)::text) AND (s2.param = s.param) AND (((s2.numero)::text = (s.numero)::text) OR (s2.destinatario = s.destinatario)) AND ((s2.stato = ANY (ARRAY[(4)::bigint, ('-1001'::integer)::bigint])) OR (s2.dataricevuta IS NOT NULL))))) AS destinatario_ricevuto
   FROM public.allerter_sms s
  ORDER BY
        CASE
            WHEN ((s.tipo)::text = 'superamento'::text) THEN (((s.tipo)::text || '_'::text) || s.param)
            ELSE (((s.tipo)::text || '_'::text) || (s.sottotipo)::text)
        END, s.nomedestinatario, s.numero;


ALTER TABLE public.sms_dettaglio_vw OWNER TO usrweballerte;

--
-- Name: sms_invii_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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
            count(s.dataack) AS spediti,
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
          WHERE (((s.tipo)::text = 'superamento'::text) AND (s.tentativi = 0) AND (s.stato >= 0))
          GROUP BY s.tipo, s.param, r.idvariabile, r.soglia, st.name, sv.soglia1, sv.soglia2, sv.soglia3
          ORDER BY s.tipo, s.param)
        UNION
         SELECT (((s.tipo)::text || '_'::text) || (s.sottotipo)::text) AS id,
                CASE
                    WHEN ((s.tipo)::text = 'allerta'::text) THEN ('Allerta n. '::text || (s.sottotipo)::text)
                    WHEN ((s.tipo)::text = 'monitoraggio'::text) THEN ('Monitoraggio '::text || (s.sottotipo)::text)
                    WHEN ((s.tipo)::text = 'comunicazione'::text) THEN 'Comunicazione'::text
                    ELSE NULL::text
                END AS evento,
                CASE
                    WHEN ((s.tipo)::text = 'allerta'::text) THEN 'Allerta PC'::text
                    WHEN ((s.tipo)::text = 'monitoraggio'::text) THEN 'Documento monitoraggio'::text
                    WHEN ((s.tipo)::text = 'comunicazione'::text) THEN 'Comunicazione'::text
                    ELSE NULL::text
                END AS tipo_evento,
            count(*) AS generati,
            count(s.dataack) AS spediti,
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
          WHERE (((s.tipo)::text = ANY (ARRAY[('allerta'::character varying)::text, ('monitoraggio'::character varying)::text, ('comunicazione'::character varying)::text])) AND (s.tentativi = 0) AND (s.stato >= 0))
          GROUP BY s.tipo, s.sottotipo) x
  ORDER BY x.creazione DESC;


ALTER TABLE public.sms_invii_vw OWNER TO usrweballerte;

--
-- Name: valanghe_email_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.valanghe_email_vw AS
 SELECT org_email_vw.name AS gruppo,
    org_email_vw.firstname,
    org_email_vw.lastname,
    org_email_vw.valore AS email
   FROM public.org_email_vw
  WHERE (org_email_vw.organizationid = ANY (ARRAY[(238662)::bigint, (238668)::bigint, (238674)::bigint, (515378)::bigint]));


ALTER TABLE public.valanghe_email_vw OWNER TO usrweballerte;

--
-- Name: valanghe_email_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.valanghe_email_vw_2 AS
 SELECT org_email_vw_2.uuid,
    org_email_vw_2.name AS gruppo,
    org_email_vw_2.firstname,
    org_email_vw_2.lastname,
    org_email_vw_2.valore AS email
   FROM public.org_email_vw_2
  WHERE (org_email_vw_2.organizationid = ANY (ARRAY[(238662)::bigint, (238668)::bigint, (238674)::bigint, (515378)::bigint]));


ALTER TABLE public.valanghe_email_vw_2 OWNER TO usrweballerte;

--
-- Name: valanghe_numeri_vw; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.valanghe_numeri_vw AS
 SELECT org_numeri_vw.name AS gruppo,
    org_numeri_vw.firstname,
    org_numeri_vw.lastname,
    org_numeri_vw.valore AS numero
   FROM public.org_numeri_vw
  WHERE (org_numeri_vw.organizationid = ANY (ARRAY[(238662)::bigint, (238668)::bigint, (238674)::bigint, (515378)::bigint]));


ALTER TABLE public.valanghe_numeri_vw OWNER TO usrweballerte;

--
-- Name: valanghe_numeri_vw_2; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.valanghe_numeri_vw_2 AS
 SELECT org_numeri_vw_2.uuid,
    org_numeri_vw_2.name AS gruppo,
    org_numeri_vw_2.firstname,
    org_numeri_vw_2.lastname,
    org_numeri_vw_2.valore AS numero
   FROM public.org_numeri_vw_2
  WHERE (org_numeri_vw_2.organizationid = ANY (ARRAY[(238662)::bigint, (238668)::bigint, (238674)::bigint, (515378)::bigint]));


ALTER TABLE public.valanghe_numeri_vw_2 OWNER TO usrweballerte;

--
-- Name: ultimi_due_valori_sensori; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.ultimi_due_valori_sensori OWNER TO usrweballerte;


--
-- Name: spike_idrometri; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.spike_idrometri AS
 SELECT i.nomerubrica,
    u.idstazione,
    u.idvariabile,
    v.value AS ult,
    v2.value AS penult,
    (v.value - v2.value) AS delta,
    i.sogliaspike
   FROM (((public.ultimi_due_valori_sensori u
     JOIN public.bollettino_idrometro i ON (((i.stazioneid)::text = (u.idstazione)::text)))
     JOIN public.bollettino_valoresensore v ON ((((v.idstazione)::text = (u.idstazione)::text) AND ((v.idvariabile)::text = (u.idvariabile)::text) AND (v.datetime = u.dataultimovalore))))
     JOIN public.bollettino_valoresensore v2 ON ((((v2.idstazione)::text = (u.idstazione)::text) AND ((v2.idvariabile)::text = (u.idvariabile)::text) AND (v2.datetime = u.datapenultimovalore))))
  WHERE (((u.idvariabile)::text = '254,0,0/1,-,-,-/B13215'::text) AND ((v.value - v2.value) > i.sogliaspike) AND (i.sogliaspike > (0.0)::double precision));


ALTER TABLE public.spike_idrometri OWNER TO usrweballerte;

--
-- Name: view_staz_sens; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.view_staz_sens OWNER TO usrweballerte;

--
-- Name: view_staz_sens_old; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.view_staz_sens_old AS
 SELECT vs.datetime,
    staz.id_,
    vs.value,
    staz.lat,
    staz.lon,
    staz.name,
    stazvar.idvariabile
   FROM ((public.bollettino_stazionevariabile stazvar
     JOIN public.bollettino_stazione staz ON (((stazvar.idstazione)::text = (staz.id_)::text)))
     LEFT JOIN public.bollettino_valoresensore vs ON (((vs.idstazione)::text = (staz.id_)::text)));


ALTER TABLE public.view_staz_sens_old OWNER TO usrweballerte;

--
-- Name: visualizzazioni_allerta_vw; Type: VIEW; Schema: public; Owner: usrweballerte
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


ALTER TABLE public.visualizzazioni_allerta_vw OWNER TO usrweballerte;

-- Name: view_staz_sensore_30m; Type: VIEW; Schema: public; Owner: usrweballerte

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


ALTER TABLE public.view_staz_sensore_30m OWNER TO usrweballerte;

-- Name: view_staz_sensore_30m_old; Type: VIEW; Schema: public; Owner: usrweballerte

CREATE VIEW public.view_staz_sensore_30m_old AS
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM public.bollettino_stazionevariabile
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,3600/1,-,-,-/B13011'::text) AND (NOT ((bollettino_stazionevariabile.idstazione)::text IN ( SELECT bollettino_stazionevariabile_1.idstazione
           FROM public.bollettino_stazionevariabile bollettino_stazionevariabile_1
          WHERE ((bollettino_stazionevariabile_1.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text)))) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL))
UNION
 SELECT bollettino_stazionevariabile.uuid_,
    bollettino_stazionevariabile.id_,
    bollettino_stazionevariabile.idstazione,
    bollettino_stazionevariabile.idvariabile,
    bollettino_stazionevariabile.dataultimovalore,
    bollettino_stazionevariabile.soglia1,
    bollettino_stazionevariabile.soglia2,
    bollettino_stazionevariabile.soglia3
   FROM public.bollettino_stazionevariabile
  WHERE (((bollettino_stazionevariabile.idvariabile)::text = '1,0,1800/1,-,-,-/B13011'::text) AND (bollettino_stazionevariabile.dataultimovalore IS NOT NULL));
  
  
ALTER TABLE public.view_staz_sensore_30m_old OWNER TO usrweballerte;


CREATE VIEW public.idro AS
 SELECT DISTINCT s.id_ AS stazione,
    s.name
   FROM ((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile v ON (((s.id_)::text = (v.idstazione)::text)))
     JOIN public.bollettino_valoresensore val ON (((val.idstazione)::text = (v.idstazione)::text)))
  WHERE ((v.idvariabile)::text ~~ '%B13215%'::text);


ALTER TABLE public.idro OWNER TO usrweballerte;



--
-- Name: pluvio; Type: VIEW; Schema: public; Owner: usrweballerte
--

CREATE VIEW public.pluvio AS
 SELECT DISTINCT s.id_ AS stazione,
    s.name
   FROM ((public.bollettino_stazione s
     JOIN public.bollettino_stazionevariabile v ON (((s.id_)::text = (v.idstazione)::text)))
     JOIN public.bollettino_valoresensore val ON (((val.idstazione)::text = (v.idstazione)::text)))
  WHERE (((v.idvariabile)::text ~~ '%B13011%'::text) AND ((val.idvariabile)::text = (v.idvariabile)::text));


ALTER TABLE public.pluvio OWNER TO usrweballerte;



--
-- Name: TABLE meteomont_email_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.meteomont_email_vw TO PUBLIC;


--
-- Name: TABLE meteomont_numeri_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.meteomont_numeri_vw TO PUBLIC;


--
-- Name: TABLE meteomont_rubrica_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.meteomont_rubrica_vw TO PUBLIC;


--
-- Name: TABLE monitoraggio_email_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.monitoraggio_email_vw TO PUBLIC;


--
-- Name: TABLE monitoraggio_numeri_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.monitoraggio_numeri_vw TO PUBLIC;


--
-- Name: TABLE monitoraggio_rubrica_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.monitoraggio_rubrica_vw TO PUBLIC;


--
-- Name: TABLE new_area_rubrica_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_area_rubrica_vw TO PUBLIC;


--
-- Name: TABLE new_meteomont_email_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_meteomont_email_vw TO PUBLIC;


--
-- Name: TABLE new_meteomont_numeri_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_meteomont_numeri_vw TO PUBLIC;


--
-- Name: TABLE new_meteomont_rubrica_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_meteomont_rubrica_vw TO PUBLIC;


--
-- Name: TABLE new_monitoraggio_email_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_monitoraggio_email_vw TO PUBLIC;


--
-- Name: TABLE new_monitoraggio_numeri_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_monitoraggio_numeri_vw TO PUBLIC;


--
-- Name: TABLE new_monitoraggio_rubrica_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.new_monitoraggio_rubrica_vw TO PUBLIC;


--
-- Name: TABLE recapiti_agenzia_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.recapiti_agenzia_vw TO PUBLIC;


--
-- Name: TABLE recapiti_comuni_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.recapiti_comuni_vw TO PUBLIC;


--
-- Name: TABLE visualizzazioni_allerta_vw; Type: ACL; Schema: public; Owner: usrweballerte
--

GRANT SELECT ON TABLE public.visualizzazioni_allerta_vw TO PUBLIC;


--
-- PostgreSQL database dump complete
--

