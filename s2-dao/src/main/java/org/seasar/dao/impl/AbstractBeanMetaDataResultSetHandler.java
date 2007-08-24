/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
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
package org.seasar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.seasar.dao.BeanMetaData;
import org.seasar.dao.RelationPropertyType;
import org.seasar.dao.RelationRowCreator;
import org.seasar.dao.RowCreator;

/**
 * @author jflute
 */
public abstract class AbstractBeanMetaDataResultSetHandler extends
        AbstractDtoMetaDataResultSetHandler {

    private BeanMetaData beanMetaData;

    private RowCreator rowCreator;// [DAO-118] (2007/08/25)

    private RelationRowCreator relationRowCreator;

    public AbstractBeanMetaDataResultSetHandler(BeanMetaData beanMetaData,
            RowCreator rowCreator, RelationRowCreator relationRowCreator) {
        super(beanMetaData);
        this.beanMetaData = beanMetaData;
        this.rowCreator = rowCreator;
        this.relationRowCreator = relationRowCreator;
    }

    public BeanMetaData getBeanMetaData() {
        return beanMetaData;
    }

    /**
     * @param rs Result set. (NotNull)
     * @param columnNames The set of column name. (NotNull)
     * @param propertyCache The set of property cache. The element type of set is PropertyType. (NotNull)
     * @return Created row. (NotNull)
     * @throws SQLException
     */
    protected Object createRow(ResultSet rs, Set columnNames, Set propertyCache)
            throws SQLException {
        return rowCreator.createRow(rs, columnNames, beanMetaData,
                propertyCache);
    }

    /**
     * @param rs Result set. (NotNull)
     * @param rpt The type of relation property. (NotNull)
     * @param columnNames The set of column name. (NotNull)
     * @param relKeyValues The map of rel key values. (Nullable)
     * @param relationPropertyCache The map of relation property cache. The key is String(relationNoSuffix) and the value is Set(PropertyType). (NotNull)
     * @return Created relation row. (Nullable)
     * @throws SQLException
     */
    protected Object createRelationRow(ResultSet rs, RelationPropertyType rpt,
            Set columnNames, Map relKeyValues, Map relationPropertyCache)
            throws SQLException {
        return relationRowCreator.createRelationRow(rs, rpt, columnNames,
                relKeyValues, relationPropertyCache);
    }

    protected void postCreateRow(final Object row) {
        final BeanMetaData bmd = getBeanMetaData();
        final Set names = bmd.getModifiedPropertyNames(row);
        names.clear();
    }

}
