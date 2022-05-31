package com.solvd.serviceStation.dao.myBatisImpl;


import com.solvd.serviceStation.classes.TimeToWork;
import com.solvd.serviceStation.dao.ITimeToWorkDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class TimeToWorkDAO implements ITimeToWorkDAO {
    private static final Logger LOGGER = LogManager.getLogger(AutoDAO.class);
    private static ITimeToWorkDAO timeMapper;
    private static SqlSession sqlSession;
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            LOGGER.info(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }


    @Override
    public TimeToWork getEntityById(int idTime) throws SQLException {
        timeMapper = sqlSessionFactory.openSession().getMapper(ITimeToWorkDAO.class);
        TimeToWork time = timeMapper.getEntityById(idTime);
        return time;
    }

    @Override
    public void saveEntity(TimeToWork entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(TimeToWork entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(TimeToWork entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<TimeToWork> getAllTimeToWork() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<TimeToWork> autos = sqlSession.selectList("showAll");
            autos.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
        return getAllTimeToWork();
    }
}


