package org.seasar.dao.handler;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.seasar.dao.ResultSetHandlerFactory;
import org.seasar.framework.exception.SQLRuntimeException;
import org.seasar.framework.exception.SRuntimeException;
import org.seasar.framework.util.ResultSetUtil;
import org.seasar.framework.util.StatementUtil;

/**
 * @author manhole
 */
public class ProcedureHandlerImpl extends AbstractBasicProcedureHandler {

    private Method daoMethod;

    private ResultSetHandlerFactory resultSetHandlerFactory;

    private int outParameterNumbers;

    public void initialize() {
        outParameterNumbers = initTypes();
    }

    protected Object execute(Connection connection, Object[] args) {
        CallableStatement cs = null;
        try {
            cs = prepareCallableStatement(connection);
            bindArgs(cs, args);
            if (cs.execute()) {
                return handleResultSet(cs);
            } else {
                return handleNoResultSet(cs);
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            StatementUtil.close(cs);
        }
    }

    protected Object handleResultSet(CallableStatement cs) throws SQLException {
        ResultSet rs = null;
        try {
            rs = cs.getResultSet();
            if (rs == null) {
                throw new IllegalStateException("JDBC Driver's BUG");
            }
            return resultSetHandlerFactory.createResultSetHandler(daoMethod)
                    .handle(rs);
        } finally {
            ResultSetUtil.close(rs);
        }
    }

    protected Object handleNoResultSet(CallableStatement cs)
            throws SQLException {
        final Class returnType = daoMethod.getReturnType();
        if (Map.class.isAssignableFrom(returnType)) {
            Map result = new HashMap();
            for (int i = 0; i < columnInOutTypes.length; i++) {
                if (isOutputColum(columnInOutTypes[i].intValue())) {
                    result.put(columnNames[i], cs.getObject(i + 1));
                }
            }
            return result;
        } else {
            if (outParameterNumbers > 1) {
                throw new SRuntimeException("EDAO0010");
            }
            for (int i = 0; i < columnInOutTypes.length; i++) {
                if (isOutputColum(columnInOutTypes[i].intValue())) {
                    return cs.getObject(i + 1);
                }
            }
            return null;
        }
    }

    public void setDaoMethod(Method method) {
        this.daoMethod = method;
    }

    public void setResultSetHandlerFactory(
            ResultSetHandlerFactory resultSetHandlerFactory) {
        this.resultSetHandlerFactory = resultSetHandlerFactory;
    }

}
