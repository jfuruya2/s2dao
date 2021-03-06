/*
 * Copyright 2004-2011 the Seasar Foundation and the Others.
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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class MockResultSetBase implements ResultSet {

    public int getConcurrency() throws SQLException {
        return 0;
    }

    public int getFetchDirection() throws SQLException {
        return 0;
    }

    public int getFetchSize() throws SQLException {
        return 0;
    }

    public int getRow() throws SQLException {
        return 0;
    }

    public int getType() throws SQLException {
        return 0;
    }

    public void afterLast() throws SQLException {
    }

    public void beforeFirst() throws SQLException {
    }

    public void cancelRowUpdates() throws SQLException {
    }

    public void clearWarnings() throws SQLException {
    }

    public void close() throws SQLException {
    }

    public void deleteRow() throws SQLException {
    }

    public void insertRow() throws SQLException {
    }

    public void moveToCurrentRow() throws SQLException {
    }

    public void moveToInsertRow() throws SQLException {
    }

    public void refreshRow() throws SQLException {
    }

    public void updateRow() throws SQLException {
    }

    public boolean first() throws SQLException {
        return false;
    }

    public boolean isAfterLast() throws SQLException {
        return false;
    }

    public boolean isBeforeFirst() throws SQLException {
        return false;
    }

    public boolean isFirst() throws SQLException {
        return false;
    }

    public boolean isLast() throws SQLException {
        return false;
    }

    public boolean last() throws SQLException {
        return false;
    }

    public boolean next() throws SQLException {
        return false;
    }

    public boolean previous() throws SQLException {
        return false;
    }

    public boolean rowDeleted() throws SQLException {
        return false;
    }

    public boolean rowInserted() throws SQLException {
        return false;
    }

    public boolean rowUpdated() throws SQLException {
        return false;
    }

    public boolean wasNull() throws SQLException {
        return false;
    }

    public byte getByte(int columnIndex) throws SQLException {
        return 0;
    }

    public double getDouble(int columnIndex) throws SQLException {
        return 0;
    }

    public float getFloat(int columnIndex) throws SQLException {
        return 0;
    }

    public int getInt(int columnIndex) throws SQLException {
        return 0;
    }

    public long getLong(int columnIndex) throws SQLException {
        return 0;
    }

    public short getShort(int columnIndex) throws SQLException {
        return 0;
    }

    public void setFetchDirection(int direction) throws SQLException {
    }

    public void setFetchSize(int rows) throws SQLException {
    }

    public void updateNull(int columnIndex) throws SQLException {
    }

    public boolean absolute(int row) throws SQLException {
        return false;
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return false;
    }

    public boolean relative(int rows) throws SQLException {
        return false;
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return null;
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return null;
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return null;
    }

    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return null;
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length)
            throws SQLException {
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length)
            throws SQLException {
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return null;
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length)
            throws SQLException {
    }

    public Object getObject(int columnIndex) throws SQLException {
        return null;
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
    }

    public void updateObject(int columnIndex, Object x, int scale)
            throws SQLException {
    }

    public String getCursorName() throws SQLException {
        return null;
    }

    public String getString(int columnIndex) throws SQLException {
        return null;
    }

    public void updateString(int columnIndex, String x) throws SQLException {
    }

    public byte getByte(String columnName) throws SQLException {
        return 0;
    }

    public double getDouble(String columnName) throws SQLException {
        return 0;
    }

    public float getFloat(String columnName) throws SQLException {
        return 0;
    }

    public int findColumn(String columnName) throws SQLException {
        return 0;
    }

    public int getInt(String columnName) throws SQLException {
        return 0;
    }

    public long getLong(String columnName) throws SQLException {
        return 0;
    }

    public short getShort(String columnName) throws SQLException {
        return 0;
    }

    public void updateNull(String columnName) throws SQLException {
    }

    public boolean getBoolean(String columnName) throws SQLException {
        return false;
    }

    public byte[] getBytes(String columnName) throws SQLException {
        return null;
    }

    public void updateByte(String columnName, byte x) throws SQLException {
    }

    public void updateDouble(String columnName, double x) throws SQLException {
    }

    public void updateFloat(String columnName, float x) throws SQLException {
    }

    public void updateInt(String columnName, int x) throws SQLException {
    }

    public void updateLong(String columnName, long x) throws SQLException {
    }

    public void updateShort(String columnName, short x) throws SQLException {
    }

    public void updateBoolean(String columnName, boolean x) throws SQLException {
    }

    public void updateBytes(String columnName, byte[] x) throws SQLException {
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return null;
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale)
            throws SQLException {
        return null;
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x)
            throws SQLException {
    }

    public URL getURL(int columnIndex) throws SQLException {
        return null;
    }

    public Array getArray(int i) throws SQLException {
        return null;
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
    }

    public Blob getBlob(int i) throws SQLException {
        return null;
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
    }

    public Clob getClob(int i) throws SQLException {
        return null;
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
    }

    public Date getDate(int columnIndex) throws SQLException {
        return null;
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
    }

    public Ref getRef(int i) throws SQLException {
        return null;
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return null;
    }

    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    public Statement getStatement() throws SQLException {
        return null;
    }

    public Time getTime(int columnIndex) throws SQLException {
        return null;
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return null;
    }

    public void updateTimestamp(int columnIndex, Timestamp x)
            throws SQLException {
    }

    public InputStream getAsciiStream(String columnName) throws SQLException {
        return null;
    }

    public InputStream getBinaryStream(String columnName) throws SQLException {
        return null;
    }

    public InputStream getUnicodeStream(String columnName) throws SQLException {
        return null;
    }

    public void updateAsciiStream(String columnName, InputStream x, int length)
            throws SQLException {
    }

    public void updateBinaryStream(String columnName, InputStream x, int length)
            throws SQLException {
    }

    public Reader getCharacterStream(String columnName) throws SQLException {
        return null;
    }

    public void updateCharacterStream(String columnName, Reader reader,
            int length) throws SQLException {
    }

    public Object getObject(String columnName) throws SQLException {
        return null;
    }

    public void updateObject(String columnName, Object x) throws SQLException {
    }

    public void updateObject(String columnName, Object x, int scale)
            throws SQLException {
    }

    public Object getObject(int i, Map map) throws SQLException {
        return null;
    }

    public String getString(String columnName) throws SQLException {
        return null;
    }

    public void updateString(String columnName, String x) throws SQLException {
    }

    public BigDecimal getBigDecimal(String columnName) throws SQLException {
        return null;
    }

    public BigDecimal getBigDecimal(String columnName, int scale)
            throws SQLException {
        return null;
    }

    public void updateBigDecimal(String columnName, BigDecimal x)
            throws SQLException {
    }

    public URL getURL(String columnName) throws SQLException {
        return null;
    }

    public Array getArray(String colName) throws SQLException {
        return null;
    }

    public void updateArray(String columnName, Array x) throws SQLException {
    }

    public Blob getBlob(String colName) throws SQLException {
        return null;
    }

    public void updateBlob(String columnName, Blob x) throws SQLException {
    }

    public Clob getClob(String colName) throws SQLException {
        return null;
    }

    public void updateClob(String columnName, Clob x) throws SQLException {
    }

    public Date getDate(String columnName) throws SQLException {
        return null;
    }

    public void updateDate(String columnName, Date x) throws SQLException {
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return null;
    }

    public Ref getRef(String colName) throws SQLException {
        return null;
    }

    public void updateRef(String columnName, Ref x) throws SQLException {
    }

    public Time getTime(String columnName) throws SQLException {
        return null;
    }

    public void updateTime(String columnName, Time x) throws SQLException {
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return null;
    }

    public Timestamp getTimestamp(String columnName) throws SQLException {
        return null;
    }

    public void updateTimestamp(String columnName, Timestamp x)
            throws SQLException {
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal)
            throws SQLException {
        return null;
    }

    public Object getObject(String colName, Map map) throws SQLException {
        return null;
    }

    public Date getDate(String columnName, Calendar cal) throws SQLException {
        return null;
    }

    public Time getTime(String columnName, Calendar cal) throws SQLException {
        return null;
    }

    public Timestamp getTimestamp(String columnName, Calendar cal)
            throws SQLException {
        return null;
    }

}
