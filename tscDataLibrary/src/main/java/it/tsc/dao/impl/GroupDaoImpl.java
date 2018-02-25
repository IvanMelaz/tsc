/**
 *
 */
package it.tsc.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.GroupDao;
import it.tsc.domain.Group;
import it.tsc.domain.GroupUserLink;
import it.tsc.domain.key.UserGroupKey;
import it.tsc.service.SequenceService;

/**
 * @author astraservice
 *
 */
@Repository("groupDao")
public class GroupDaoImpl extends BaseDao implements GroupDao {
	private static Logger logger = LoggerFactory.getLogger(GroupDaoImpl.class);
	@Autowired
	private SequenceService sequenceService;
	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.GroupDao#getAllGroups()
	 */
	@Override
	public List<Group> getAllGroups() {
		TypedQuery<Group> query = getEntityManager()
				.createNamedQuery(Group.SELECT_GROUPS, Group.class);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.GroupDao#addGroup(java.lang.String)
	 */
	@Override
	public void addGroup(String groupname) {
		Group group = new Group();
		EntityTransaction tx = getEntityTransaction();
		try {
			tx.begin();
			group.setGroupId(sequenceService.getNextVal(Group.TABLE_NAME));
			group.setGroupName(groupname);
			getEntityManager().persist(group);
			getEntityManager().flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("addGroup: {}", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.GroupDao#removeGroup(java.lang.String)
	 */
	@Override
	public void removeGroup(String groupname) {
		Group group = new Group();
		EntityTransaction tx = getEntityTransaction();
		try {
			tx.begin();
			group.setGroupName(groupname);
			getEntityManager().remove(group);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("removeGroup: {}", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.GroupDao#addUserToGroup(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addUserToGroup(String username, String groupname) {
		GroupUserLink groupUserLink = new GroupUserLink();
		UserGroupKey key = new UserGroupKey();
		key.setUsername(username);
		key.setGroupid(findByName(groupname).getGroupId());
		groupUserLink.setKey(key);
		EntityTransaction tx = getEntityTransaction();
		try {
			tx.begin();
			getEntityManager().persist(groupUserLink);
			getEntityManager().flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("addGroup: {}", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.GroupDao#removeUserFromGroup(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void removeUserFromGroup(String username, String groupname) {
		UserGroupKey key = new UserGroupKey();
		key.setUsername(username);
		Long groupId = findByName(groupname).getGroupId();
		Validate.isTrue(groupId != 0, "groupId cannot be 0");
		key.setGroupid(findByName(groupname).getGroupId());
		EntityTransaction tx = getEntityTransaction();
		try {
			tx.begin();
			GroupUserLink g = getEntityManager().find(GroupUserLink.class, key);
			getEntityManager().remove(g);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("addGroup: {}", e);
		}
	}

	@Override
	public Group findByName(String groupname) {
		TypedQuery<Group> query = getEntityManager()
				.createNamedQuery(Group.SELECT_GROUP_BY_NAME, Group.class);
		query.setParameter("groupName", groupname);
		return query.getSingleResult();
	}

}
