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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.seasar.dao.BeanMetaData;
import org.seasar.dao.RelationRowCreator;
import org.seasar.dao.RowCreator;
import org.seasar.dao.unit.S2DaoTestCase;
import org.seasar.extension.jdbc.ResultSetHandler;

public class BeanListMetaDataResultSetHandlerTest extends S2DaoTestCase {

    private BeanMetaData beanMetaData;

    public void testHandle() throws Exception {
        ResultSetHandler handler = new BeanListMetaDataResultSetHandler(
                beanMetaData, createRowCreator(), createRelationRowCreator());
        String sql = "select * from emp";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List ret = null;
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ret = (List) handler.handle(rs);
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        assertNotNull("1", ret);
        for (int i = 0; i < ret.size(); ++i) {
            Employee emp = (Employee) ret.get(i);
            System.out.println(emp.getEmpno() + "," + emp.getEname());
        }
    }

    public void testHandle2() throws Exception {
        ResultSetHandler handler = new BeanListMetaDataResultSetHandler(
                beanMetaData, createRowCreator(), createRelationRowCreator());
        String sql = "select emp.*, dept.dname as dname_0 from emp, dept where emp.deptno = dept.deptno and emp.deptno = 20";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List ret = null;
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ret = (List) handler.handle(rs);
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        assertNotNull("1", ret);
        for (int i = 0; i < ret.size(); ++i) {
            Employee emp = (Employee) ret.get(i);
            System.out.println(emp);
            Department dept = emp.getDepartment();
            assertNotNull("2", dept);
            assertEquals("3", emp.getDeptno(), dept.getDeptno());
            assertNotNull("4", dept.getDname());
        }
    }

    public void testHandle3() throws Exception {
        ResultSetHandler handler = new BeanListMetaDataResultSetHandler(
                beanMetaData, createRowCreator(), createRelationRowCreator());
        String sql = "select emp.*, dept.deptno as deptno_0, dept.dname as dname_0 from emp, dept where dept.deptno = 20 and emp.deptno = dept.deptno";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List ret = null;
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ret = (List) handler.handle(rs);
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
        Employee emp = (Employee) ret.get(0);
        Employee emp2 = (Employee) ret.get(1);
        assertSame("1", emp.getDepartment(), emp2.getDepartment());
    }

    protected RowCreator createRowCreator() {// [DAO-118] (2007/08/25)
        return new RowCreatorImpl();
    }

    protected RelationRowCreator createRelationRowCreator() {
        return new RelationRowCreatorImpl();
    }
    
    public void setUp() {
        include("j2ee.dicon");
    }

    protected void setUpAfterBindFields() throws Throwable {
        super.setUpAfterBindFields();
        beanMetaData = createBeanMetaData(Employee.class);
    }

}
