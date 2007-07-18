/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.dao.pager;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.ResultSetFactory;

/**
 * @author yamamoto
 * @author agata
 */
public class PagerResultSetFactoryLimitOffsetWrapper extends
        AbstractPagerResultSetFactory implements ResultSetFactory {

    /**
     * コンストラクタ(test only)
     * 
     * @param resultSetFactory
     *            オリジナルのResultSetFactory
     */
    PagerResultSetFactoryLimitOffsetWrapper(ResultSetFactory resultSetFactory,
            String productName) {
        super(resultSetFactory, productName);
    }

    /**
     * コンストラクタ
     * 
     * @param resultSetFactory
     *            オリジナルのResultSetFactory
     */
    public PagerResultSetFactoryLimitOffsetWrapper(
            ResultSetFactory resultSetFactory, DataSource dataSource) {
        super(resultSetFactory, dataSource);
    }

    /**
     * limit offsetを付加したSQLを作成します。
     * 
     * @param baseSQL
     * @param limit
     * @param offset
     * @return
     */
    String makeLimitOffsetSql(String baseSQL, int limit, int offset) {
        StringBuffer sqlBuf = new StringBuffer(baseSQL);
        sqlBuf.append(" LIMIT ");
        sqlBuf.append(limit);
        sqlBuf.append(" OFFSET ");
        sqlBuf.append(offset);
        return sqlBuf.toString();
    }

    String makeCountSql(String baseSQL) {
        StringBuffer sqlBuf = new StringBuffer("SELECT count(*) FROM (");
        if (isChopOrderBy()) {
            sqlBuf.append(chopOrderBy(baseSQL));
        } else {
            sqlBuf.append(baseSQL);
        }
        sqlBuf.append(") AS total");
        return sqlBuf.toString();
    }
}
