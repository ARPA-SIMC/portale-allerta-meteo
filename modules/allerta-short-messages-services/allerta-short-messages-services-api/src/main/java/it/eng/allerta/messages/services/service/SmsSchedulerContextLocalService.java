/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerter.service.SMSLocalService;

import java.io.Serializable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SmsSchedulerContext. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SmsSchedulerContextLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerta.messages.services.service.impl.SmsSchedulerContextLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the sms scheduler context local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SmsSchedulerContextLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the sms scheduler context to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmsSchedulerContext addSmsSchedulerContext(
		SmsSchedulerContext smsSchedulerContext);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	@Transactional(enabled = false)
	public SmsSchedulerContext createSmsSchedulerContext(String varId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the sms scheduler context from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmsSchedulerContext deleteSmsSchedulerContext(
		SmsSchedulerContext smsSchedulerContext);

	/**
	 * Deletes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmsSchedulerContext deleteSmsSchedulerContext(String varId)
		throws PortalException;

	/**
	 * Spegne l'eventuale scheduler attivo se presente in questo host oppure il relativo watchdog.
	 */
	public void doPortalDestroyInExclusiveMode() throws SystemException;

	/**
	 * Usata nella fase di init della portlet, quindi al suo deploy (può avvenire all'avvio del server oppure al redeploy della portlet).
	 * Se esiste uno scheduler attivo lo spegne e riavvia il tutto in modalità esclusiva, oppure diventa un watchdog.
	 * Se lo scheduler non è attivo avvia lo scheduler sul nodo corrente in modalità esclusiva.
	 */
	public void doPortalInitInExclusiveMode(String hostIp, String port)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SmsSchedulerContext fetchSmsSchedulerContext(String varId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String[] getEmailList() throws SystemException;

	/**
	 * Ritorna hostip,port della macchina che contiene lo scheduler attualmente attivo.
	 *
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getHostIPAndPortOfCurrentScheduler();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMSLocalService getSMSLocalService() throws InterruptedException;

	/**
	 * Returns the sms scheduler context with the primary key.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SmsSchedulerContext getSmsSchedulerContext(String varId)
		throws PortalException;

	/**
	 * Returns a range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @return the range of sms scheduler contexts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmsSchedulerContext> getSmsSchedulerContexts(
		int start, int end);

	/**
	 * Returns the number of sms scheduler contexts.
	 *
	 * @return the number of sms scheduler contexts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmsSchedulerContextsCount();

	/**
	 * Se lo scheduler è morto prova a creare una nuova istanza dello scheduler in modalità esclusiva
	 */
	public boolean ifDeadTryToBecomeScheduler(String hostIp, String port)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSchedulerInThisHost() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSmsSchedulerDead() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSmsSchedulerDead(
			TimeUnit heartbeatPeriodTimeUnit, long heartbeatPeriod,
			long heartbeatOccurrences)
		throws InterruptedException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSmsWatchdogSuspend() throws SystemException;

	public void resetSmsSchedulerState(String smsSchedulerStateNewVal)
		throws SystemException;

	/**
	 * Ripristino di eventuali stati non consistenti degli SMS a causa dello shutdwon del server;
	 * devono essere inviati nuovamente : se rimasti nello stato 2 e 6 non sono mai stati inviati
	 */
	public void ripristinaStatiInconsistentiSMS();

	public void sendMailWithPlainText(String body);

	public boolean setSmsSchdulerContextInExclusiveMode(
			String querySQL, String varId, String value)
		throws SystemException;

	public void updateHeartbeatInstant(long timestamp) throws SystemException;

	public long updateHeartbeatInstantNow() throws SystemException;

	/**
	 * Updates the sms scheduler context in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmsSchedulerContext updateSmsSchedulerContext(
		SmsSchedulerContext smsSchedulerContext);

	@Transactional(
		isolation = Isolation.READ_COMMITTED,
		propagation = Propagation.REQUIRES_NEW,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public SmsSchedulerContext updateSmsSchedulerContextNewTransaction(
			SmsSchedulerContext smsSchedulerContext)
		throws SystemException;

}