package com.test.demo.dao;

import com.test.demo.domain.UserInfo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

@Repository
public class UserInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<UserInfo> list() {
        Session session = sessionFactory.getCurrentSession();
        List<UserInfo> rs = session.createCriteria(UserInfo.class).list();
        return rs;
    }

    public UserInfo load(Long id) {
        Session session = sessionFactory.getCurrentSession();
        UserInfo userInfo = (UserInfo) session.load(UserInfo.class, id);
        return userInfo;
    }

    public boolean save(UserInfo userInfo) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(userInfo);
        return id instanceof Long;
    }

    public UserInfo load(String name) {
        Session session = sessionFactory.getCurrentSession();
        List<UserInfo> rs = session.createCriteria(UserInfo.class)
                .add(Restrictions.eq("name", name))
                .setMaxResults(1)
                .list();
        // session.createSQLQuery("from UserInfo where name = #{name}").setString("name", name);

        if (!rs.isEmpty()) {
            return rs.get(0);
        }
        return null;
    }
}
