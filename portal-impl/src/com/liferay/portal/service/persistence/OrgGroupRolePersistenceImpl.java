/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.NoSuchOrgGroupRoleException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.OrgGroupRole;
import com.liferay.portal.model.impl.OrgGroupRoleImpl;
import com.liferay.portal.model.impl.OrgGroupRoleModelImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="OrgGroupRolePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OrgGroupRolePersistence
 * @see       OrgGroupRoleUtil
 * @generated
 */
public class OrgGroupRolePersistenceImpl extends BasePersistenceImpl<OrgGroupRole>
	implements OrgGroupRolePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = OrgGroupRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPID = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROLEID = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByRoleId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLEID = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByRoleId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByRoleId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(OrgGroupRole orgGroupRole) {
		EntityCacheUtil.putResult(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleImpl.class, orgGroupRole.getPrimaryKey(), orgGroupRole);
	}

	public void cacheResult(List<OrgGroupRole> orgGroupRoles) {
		for (OrgGroupRole orgGroupRole : orgGroupRoles) {
			if (EntityCacheUtil.getResult(
						OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
						OrgGroupRoleImpl.class, orgGroupRole.getPrimaryKey(),
						this) == null) {
				cacheResult(orgGroupRole);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(OrgGroupRoleImpl.class.getName());
		EntityCacheUtil.clearCache(OrgGroupRoleImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public OrgGroupRole create(OrgGroupRolePK orgGroupRolePK) {
		OrgGroupRole orgGroupRole = new OrgGroupRoleImpl();

		orgGroupRole.setNew(true);
		orgGroupRole.setPrimaryKey(orgGroupRolePK);

		return orgGroupRole;
	}

	public OrgGroupRole remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove((OrgGroupRolePK)primaryKey);
	}

	public OrgGroupRole remove(OrgGroupRolePK orgGroupRolePK)
		throws NoSuchOrgGroupRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgGroupRole orgGroupRole = (OrgGroupRole)session.get(OrgGroupRoleImpl.class,
					orgGroupRolePK);

			if (orgGroupRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						orgGroupRolePK);
				}

				throw new NoSuchOrgGroupRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					orgGroupRolePK);
			}

			return remove(orgGroupRole);
		}
		catch (NoSuchOrgGroupRoleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public OrgGroupRole remove(OrgGroupRole orgGroupRole)
		throws SystemException {
		for (ModelListener<OrgGroupRole> listener : listeners) {
			listener.onBeforeRemove(orgGroupRole);
		}

		orgGroupRole = removeImpl(orgGroupRole);

		for (ModelListener<OrgGroupRole> listener : listeners) {
			listener.onAfterRemove(orgGroupRole);
		}

		return orgGroupRole;
	}

	protected OrgGroupRole removeImpl(OrgGroupRole orgGroupRole)
		throws SystemException {
		orgGroupRole = toUnwrappedModel(orgGroupRole);

		Session session = null;

		try {
			session = openSession();

			if (orgGroupRole.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(OrgGroupRoleImpl.class,
						orgGroupRole.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(orgGroupRole);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleImpl.class, orgGroupRole.getPrimaryKey());

		return orgGroupRole;
	}

	public OrgGroupRole updateImpl(
		com.liferay.portal.model.OrgGroupRole orgGroupRole, boolean merge)
		throws SystemException {
		orgGroupRole = toUnwrappedModel(orgGroupRole);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, orgGroupRole, merge);

			orgGroupRole.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
			OrgGroupRoleImpl.class, orgGroupRole.getPrimaryKey(), orgGroupRole);

		return orgGroupRole;
	}

	protected OrgGroupRole toUnwrappedModel(OrgGroupRole orgGroupRole) {
		if (orgGroupRole instanceof OrgGroupRoleImpl) {
			return orgGroupRole;
		}

		OrgGroupRoleImpl orgGroupRoleImpl = new OrgGroupRoleImpl();

		orgGroupRoleImpl.setNew(orgGroupRole.isNew());
		orgGroupRoleImpl.setPrimaryKey(orgGroupRole.getPrimaryKey());

		orgGroupRoleImpl.setOrganizationId(orgGroupRole.getOrganizationId());
		orgGroupRoleImpl.setGroupId(orgGroupRole.getGroupId());
		orgGroupRoleImpl.setRoleId(orgGroupRole.getRoleId());

		return orgGroupRoleImpl;
	}

	public OrgGroupRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((OrgGroupRolePK)primaryKey);
	}

	public OrgGroupRole findByPrimaryKey(OrgGroupRolePK orgGroupRolePK)
		throws NoSuchOrgGroupRoleException, SystemException {
		OrgGroupRole orgGroupRole = fetchByPrimaryKey(orgGroupRolePK);

		if (orgGroupRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + orgGroupRolePK);
			}

			throw new NoSuchOrgGroupRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				orgGroupRolePK);
		}

		return orgGroupRole;
	}

	public OrgGroupRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((OrgGroupRolePK)primaryKey);
	}

	public OrgGroupRole fetchByPrimaryKey(OrgGroupRolePK orgGroupRolePK)
		throws SystemException {
		OrgGroupRole orgGroupRole = (OrgGroupRole)EntityCacheUtil.getResult(OrgGroupRoleModelImpl.ENTITY_CACHE_ENABLED,
				OrgGroupRoleImpl.class, orgGroupRolePK, this);

		if (orgGroupRole == null) {
			Session session = null;

			try {
				session = openSession();

				orgGroupRole = (OrgGroupRole)session.get(OrgGroupRoleImpl.class,
						orgGroupRolePK);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (orgGroupRole != null) {
					cacheResult(orgGroupRole);
				}

				closeSession(session);
			}
		}

		return orgGroupRole;
	}

	public List<OrgGroupRole> findByGroupId(long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId) };

		List<OrgGroupRole> list = (List<OrgGroupRole>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_SELECT_ORGGROUPROLE_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgGroupRole>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgGroupRole> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	public List<OrgGroupRole> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(groupId),
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<OrgGroupRole> list = (List<OrgGroupRole>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_ORGGROUPROLE_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<OrgGroupRole>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgGroupRole>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgGroupRole findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgGroupRoleException, SystemException {
		List<OrgGroupRole> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgGroupRoleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgGroupRole findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgGroupRoleException, SystemException {
		int count = countByGroupId(groupId);

		List<OrgGroupRole> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgGroupRoleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgGroupRole[] findByGroupId_PrevAndNext(
		OrgGroupRolePK orgGroupRolePK, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgGroupRoleException, SystemException {
		OrgGroupRole orgGroupRole = findByPrimaryKey(orgGroupRolePK);

		int count = countByGroupId(groupId);

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ORGGROUPROLE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count,
					orderByComparator, orgGroupRole);

			OrgGroupRole[] array = new OrgGroupRoleImpl[3];

			array[0] = (OrgGroupRole)objArray[0];
			array[1] = (OrgGroupRole)objArray[1];
			array[2] = (OrgGroupRole)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgGroupRole> findByRoleId(long roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(roleId) };

		List<OrgGroupRole> list = (List<OrgGroupRole>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_SELECT_ORGGROUPROLE_WHERE);

				query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgGroupRole>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<OrgGroupRole> findByRoleId(long roleId, int start, int end)
		throws SystemException {
		return findByRoleId(roleId, start, end, null);
	}

	public List<OrgGroupRole> findByRoleId(long roleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(roleId),
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<OrgGroupRole> list = (List<OrgGroupRole>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_ORGGROUPROLE_WHERE);

				query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				list = (List<OrgGroupRole>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgGroupRole>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public OrgGroupRole findByRoleId_First(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgGroupRoleException, SystemException {
		List<OrgGroupRole> list = findByRoleId(roleId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("roleId=");
			msg.append(roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgGroupRoleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgGroupRole findByRoleId_Last(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgGroupRoleException, SystemException {
		int count = countByRoleId(roleId);

		List<OrgGroupRole> list = findByRoleId(roleId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("roleId=");
			msg.append(roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchOrgGroupRoleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public OrgGroupRole[] findByRoleId_PrevAndNext(
		OrgGroupRolePK orgGroupRolePK, long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgGroupRoleException, SystemException {
		OrgGroupRole orgGroupRole = findByPrimaryKey(orgGroupRolePK);

		int count = countByRoleId(roleId);

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ORGGROUPROLE_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count,
					orderByComparator, orgGroupRole);

			OrgGroupRole[] array = new OrgGroupRoleImpl[3];

			array[0] = (OrgGroupRole)objArray[0];
			array[1] = (OrgGroupRole)objArray[1];
			array[2] = (OrgGroupRole)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<OrgGroupRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<OrgGroupRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<OrgGroupRole> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<OrgGroupRole> list = (List<OrgGroupRole>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_ORGGROUPROLE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}

				sql = _SQL_SELECT_ORGGROUPROLE;

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OrgGroupRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OrgGroupRole>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<OrgGroupRole>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByGroupId(long groupId) throws SystemException {
		for (OrgGroupRole orgGroupRole : findByGroupId(groupId)) {
			remove(orgGroupRole);
		}
	}

	public void removeByRoleId(long roleId) throws SystemException {
		for (OrgGroupRole orgGroupRole : findByRoleId(roleId)) {
			remove(orgGroupRole);
		}
	}

	public void removeAll() throws SystemException {
		for (OrgGroupRole orgGroupRole : findAll()) {
			remove(orgGroupRole);
		}
	}

	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(groupId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_ORGGROUPROLE_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByRoleId(long roleId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(roleId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_ORGGROUPROLE_WHERE);

				query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORGGROUPROLE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.OrgGroupRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgGroupRole>> listenersList = new ArrayList<ModelListener<OrgGroupRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgGroupRole>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "com.liferay.portal.service.persistence.AccountPersistence")
	protected com.liferay.portal.service.persistence.AccountPersistence accountPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.AddressPersistence")
	protected com.liferay.portal.service.persistence.AddressPersistence addressPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.BrowserTrackerPersistence")
	protected com.liferay.portal.service.persistence.BrowserTrackerPersistence browserTrackerPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ClassNamePersistence")
	protected com.liferay.portal.service.persistence.ClassNamePersistence classNamePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.CompanyPersistence")
	protected com.liferay.portal.service.persistence.CompanyPersistence companyPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ContactPersistence")
	protected com.liferay.portal.service.persistence.ContactPersistence contactPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.CountryPersistence")
	protected com.liferay.portal.service.persistence.CountryPersistence countryPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.EmailAddressPersistence")
	protected com.liferay.portal.service.persistence.EmailAddressPersistence emailAddressPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.GroupPersistence")
	protected com.liferay.portal.service.persistence.GroupPersistence groupPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ImagePersistence")
	protected com.liferay.portal.service.persistence.ImagePersistence imagePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.LayoutPersistence")
	protected com.liferay.portal.service.persistence.LayoutPersistence layoutPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.LayoutPrototypePersistence")
	protected com.liferay.portal.service.persistence.LayoutPrototypePersistence layoutPrototypePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.LayoutSetPersistence")
	protected com.liferay.portal.service.persistence.LayoutSetPersistence layoutSetPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.LayoutSetPrototypePersistence")
	protected com.liferay.portal.service.persistence.LayoutSetPrototypePersistence layoutSetPrototypePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ListTypePersistence")
	protected com.liferay.portal.service.persistence.ListTypePersistence listTypePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.LockPersistence")
	protected com.liferay.portal.service.persistence.LockPersistence lockPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.MembershipRequestPersistence")
	protected com.liferay.portal.service.persistence.MembershipRequestPersistence membershipRequestPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.OrganizationPersistence")
	protected com.liferay.portal.service.persistence.OrganizationPersistence organizationPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.OrgGroupPermissionPersistence")
	protected com.liferay.portal.service.persistence.OrgGroupPermissionPersistence orgGroupPermissionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.OrgGroupRolePersistence")
	protected com.liferay.portal.service.persistence.OrgGroupRolePersistence orgGroupRolePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.OrgLaborPersistence")
	protected com.liferay.portal.service.persistence.OrgLaborPersistence orgLaborPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PasswordPolicyPersistence")
	protected com.liferay.portal.service.persistence.PasswordPolicyPersistence passwordPolicyPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PasswordPolicyRelPersistence")
	protected com.liferay.portal.service.persistence.PasswordPolicyRelPersistence passwordPolicyRelPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PasswordTrackerPersistence")
	protected com.liferay.portal.service.persistence.PasswordTrackerPersistence passwordTrackerPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PermissionPersistence")
	protected com.liferay.portal.service.persistence.PermissionPersistence permissionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PhonePersistence")
	protected com.liferay.portal.service.persistence.PhonePersistence phonePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PluginSettingPersistence")
	protected com.liferay.portal.service.persistence.PluginSettingPersistence pluginSettingPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PortletPersistence")
	protected com.liferay.portal.service.persistence.PortletPersistence portletPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PortletItemPersistence")
	protected com.liferay.portal.service.persistence.PortletItemPersistence portletItemPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.PortletPreferencesPersistence")
	protected com.liferay.portal.service.persistence.PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.RegionPersistence")
	protected com.liferay.portal.service.persistence.RegionPersistence regionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ReleasePersistence")
	protected com.liferay.portal.service.persistence.ReleasePersistence releasePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence")
	protected com.liferay.portal.service.persistence.ResourcePersistence resourcePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ResourceActionPersistence")
	protected com.liferay.portal.service.persistence.ResourceActionPersistence resourceActionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ResourceCodePersistence")
	protected com.liferay.portal.service.persistence.ResourceCodePersistence resourceCodePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ResourcePermissionPersistence")
	protected com.liferay.portal.service.persistence.ResourcePermissionPersistence resourcePermissionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.RolePersistence")
	protected com.liferay.portal.service.persistence.RolePersistence rolePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ServiceComponentPersistence")
	protected com.liferay.portal.service.persistence.ServiceComponentPersistence serviceComponentPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ShardPersistence")
	protected com.liferay.portal.service.persistence.ShardPersistence shardPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.SubscriptionPersistence")
	protected com.liferay.portal.service.persistence.SubscriptionPersistence subscriptionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.TeamPersistence")
	protected com.liferay.portal.service.persistence.TeamPersistence teamPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence")
	protected com.liferay.portal.service.persistence.UserPersistence userPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserGroupPersistence")
	protected com.liferay.portal.service.persistence.UserGroupPersistence userGroupPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserGroupGroupRolePersistence")
	protected com.liferay.portal.service.persistence.UserGroupGroupRolePersistence userGroupGroupRolePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserGroupRolePersistence")
	protected com.liferay.portal.service.persistence.UserGroupRolePersistence userGroupRolePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserIdMapperPersistence")
	protected com.liferay.portal.service.persistence.UserIdMapperPersistence userIdMapperPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserTrackerPersistence")
	protected com.liferay.portal.service.persistence.UserTrackerPersistence userTrackerPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserTrackerPathPersistence")
	protected com.liferay.portal.service.persistence.UserTrackerPathPersistence userTrackerPathPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.WebDAVPropsPersistence")
	protected com.liferay.portal.service.persistence.WebDAVPropsPersistence webDAVPropsPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.WebsitePersistence")
	protected com.liferay.portal.service.persistence.WebsitePersistence websitePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.WorkflowDefinitionLinkPersistence")
	protected com.liferay.portal.service.persistence.WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence")
	protected com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	private static final String _SQL_SELECT_ORGGROUPROLE = "SELECT orgGroupRole FROM OrgGroupRole orgGroupRole";
	private static final String _SQL_SELECT_ORGGROUPROLE_WHERE = "SELECT orgGroupRole FROM OrgGroupRole orgGroupRole WHERE ";
	private static final String _SQL_COUNT_ORGGROUPROLE = "SELECT COUNT(orgGroupRole) FROM OrgGroupRole orgGroupRole";
	private static final String _SQL_COUNT_ORGGROUPROLE_WHERE = "SELECT COUNT(orgGroupRole) FROM OrgGroupRole orgGroupRole WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "orgGroupRole.id.groupId = ?";
	private static final String _FINDER_COLUMN_ROLEID_ROLEID_2 = "orgGroupRole.id.roleId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orgGroupRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrgGroupRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrgGroupRole exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(OrgGroupRolePersistenceImpl.class);
}