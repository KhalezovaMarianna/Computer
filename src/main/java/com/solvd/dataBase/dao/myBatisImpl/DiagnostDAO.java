package com.solvd.dataBase.dao.myBatisImpl;

import com.solvd.dataBase.models.Diagnosts;
import com.solvd.dataBase.dao.IDiagnostDAO;
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

public class DiagnostDAO implements IDiagnostDAO {
    private static final Logger LOGGER = LogManager.getLogger(DiagnostDAO.class);
    private static IDiagnostDAO diagnostMapper;
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
    public Diagnosts getEntityById(int idDiagnosts) throws SQLException {
        diagnostMapper = sqlSessionFactory.openSession().getMapper(IDiagnostDAO.class);
        Diagnosts diagnost = diagnostMapper.getEntityById(idDiagnosts);
        return diagnost;
    }

    @Override
    public void saveEntity(Diagnosts entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Diagnosts entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(Diagnosts entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Diagnosts> getAllDiagnosts() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Diagnosts> diagnosts = sqlSession.selectList("getAllDiagnost");
            diagnosts.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
       return getAllDiagnosts();
    }
}
