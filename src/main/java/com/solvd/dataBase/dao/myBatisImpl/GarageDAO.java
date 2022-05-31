package com.solvd.dataBase.dao.myBatisImpl;

import com.solvd.dataBase.classes.Autos;
import com.solvd.dataBase.classes.Garages;
import com.solvd.dataBase.dao.IGarageDAO;
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

public class GarageDAO implements IGarageDAO {
    private static final Logger LOGGER = LogManager.getLogger(GarageDAO.class);
    private static IGarageDAO garageMapper;
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
    public Garages getEntityById(int idGarage) throws SQLException {
        garageMapper = sqlSessionFactory.openSession().getMapper(IGarageDAO.class);
        Garages garage = garageMapper.getEntityById(idGarage);
        return garage;
    }

    @Override
    public void saveEntity(Garages entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Garages entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(Garages entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Garages> getAllGarages() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Autos> autos = sqlSession.selectList("showAll");
            autos.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
        return getAllGarages();
    }
}
