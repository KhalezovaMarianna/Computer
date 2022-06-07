package com.solvd.dataBase.dao.myBatisImpl;

import com.solvd.dataBase.models.Masters;
import com.solvd.dataBase.dao.IMasterDAO;
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

public class MastersDAO implements IMasterDAO {
    private static final Logger LOGGER = LogManager.getLogger(MastersDAO.class);
    private static IMasterDAO masterMapper;
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
    public Masters getEntityById(int idMasters) throws SQLException {
        masterMapper = sqlSessionFactory.openSession().getMapper(IMasterDAO.class);
        Masters master = masterMapper.getEntityById(idMasters);
        return master;
    }

    @Override
    public void saveEntity(Masters entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Masters entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(Masters entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Masters> getAllMasters() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Masters> masters = sqlSession.selectList("getAll");
            masters.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
        return getAllMasters();
    }
}
