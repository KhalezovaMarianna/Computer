package com.solvd.serviceStation.dao.myBatisImpl;

import com.solvd.serviceStation.classes.Autos;
import com.solvd.serviceStation.dao.IAutoDAO;
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

public class AutoDAO implements IAutoDAO {
    private static final Logger LOGGER = LogManager.getLogger(AutoDAO.class);
    private static IAutoDAO autoMapper;
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
    public Autos getEntityById(int stateNumber) throws SQLException {
        autoMapper = sqlSessionFactory.openSession().getMapper(IAutoDAO.class);
        Autos auto = autoMapper.getEntityById(stateNumber);
        return auto;
    }

    @Override
    public void saveEntity(Autos entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Autos entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(Autos entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void getAllAutos() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Autos> autos = sqlSession.selectList("showAll");
            autos.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
    }
}

