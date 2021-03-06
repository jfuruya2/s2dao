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
package examples.dao;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

/**
 * @author azusa
 *
 */
public class ConvertTableExampleClient {

    private static final String PATH = "examples/dao/dao-convertclassname.dicon";

    public static void main(String[] args) {
        S2Container container = S2ContainerFactory.create(PATH);
        container.init();
        try {
            NoPkTableDao dao = (NoPkTableDao) container
                    .getComponent(NoPkTableDao.class);
            NoPkTable[] beans = dao.selectAll();
            for (int i = 0; i < beans.length; i++) {
                System.out.println(beans[i]);
            }
        } finally {
            container.destroy();
        }

    }

}
