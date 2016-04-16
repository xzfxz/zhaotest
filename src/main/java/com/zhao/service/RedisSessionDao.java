package com.zhao.service;

/**
 * Created by Administrator on 2016/4/13.
 */

import java.io.Serializable;

import com.zhao.util.RedisUtil;
import com.zhao.util.SerializeUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import redis.clients.jedis.Jedis;

public class RedisSessionDao extends CachingSessionDAO {

    private Jedis jedis  = RedisUtil.getJedis();

    @Override
    protected void doUpdate(Session session) {
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        jedis.set(session.getId().toString(),SerializeUtil.serialize(session).toString());
    }

    @Override
    protected void doDelete(Session session) {
        if(session!=null){
            jedis.del(session.getId().toString());
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        if(session!=null){
            Serializable sessionId = generateSessionId(session);
            assignSessionId(session, sessionId);
            jedis.set(sessionId.toString(),SerializeUtil.serialize(session).toString());
            return session.getId();
        }
        return null;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        if(serializable!=null){
            String s = jedis.get(serializable.toString());
           return (Session) SerializeUtil.deserialize(s.getBytes());
        }
        return null;
    }
}