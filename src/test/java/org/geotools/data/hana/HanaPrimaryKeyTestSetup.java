/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2016, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data.hana;

import org.geotools.jdbc.JDBCPrimaryKeyTestSetup;

/**
 * @author Sayon Kumar Saha, SAP
 * @source $URL:$
 */
public class HanaPrimaryKeyTestSetup extends JDBCPrimaryKeyTestSetup {

public HanaPrimaryKeyTestSetup() {
    super(new HanaTestSetup());
}

@Override
protected void createAutoGeneratedPrimaryKeyTable() throws Exception {
    run("CREATE COLUMN TABLE \"GeoToolsTest\".\"auto\""
            + "(\"pkey\" INTEGER, \"name\" VARCHAR(255), \"geom\" ST_GEOMETRY, PRIMARY KEY (\"pkey\"));");

    run("INSERT INTO \"GeoToolsTest\".\"auto\" (\"pkey\",\"name\",\"geom\") "
            + "VALUES (seq.NEXTVAL, 'one', NEW ST_POINT('POINT(1 1)'));");
    run("INSERT INTO \"GeoToolsTest\".\"auto\" (\"pkey\",\"name\",\"geom\") "
            + "VALUES (seq.NEXTVAL, 'two', NEW ST_POINT('POINT(2 2)'));");
    run("INSERT INTO \"GeoToolsTest\".\"auto\" (\"pkey\",\"name\",\"geom\") "
            + "VALUES (seq.NEXTVAL, 'three', NEW ST_POINT('POINT(3 3)'));");
}

@Override
protected void createSequencedPrimaryKeyTable() throws Exception {
}

@Override
protected void createNonIncrementingPrimaryKeyTable() throws Exception {
    run("CREATE COLUMN TABLE \"GeoToolsTest\".\"noninc\""
            + "(\"pkey\" INTEGER, \"name\" VARCHAR(255), \"geom\" ST_GEOMETRY, PRIMARY KEY (\"pkey\"));");

    run("INSERT INTO \"GeoToolsTest\".\"noninc\" (\"pkey\",\"name\",\"geom\") "
            + "VALUES (1, 'one', NEW ST_POINT('POINT(1 1)'));");
    run("INSERT INTO \"GeoToolsTest\".\"noninc\" (\"pkey\",\"name\",\"geom\") "
            + "VALUES (2, 'two', NEW ST_POINT('POINT(2 2)'));");
    run("INSERT INTO \"GeoToolsTest\".\"noninc\" (\"pkey\",\"name\",\"geom\") "
            + "VALUES (3, 'three', NEW ST_POINT('POINT(3 3)'));");
}

@Override
protected void createMultiColumnPrimaryKeyTable() throws Exception {
    run("CREATE COLUMN TABLE \"GeoToolsTest\".\"multi\""
            + "(\"pkey1\" INTEGER, \"pkey2\" VARCHAR(255), \"name\" VARCHAR(255), \"geom\" ST_GEOMETRY, PRIMARY KEY (\"pkey1\",\"pkey2\"));");

    run("INSERT INTO \"GeoToolsTest\".\"multi\" (\"pkey1\", \"pkey2\", \"name\",\"geom\") "
            + "VALUES (1, 'x', 'one', NEW ST_POINT('POINT(1 1)'));");
    run("INSERT INTO \"GeoToolsTest\".\"multi\" (\"pkey1\", \"pkey2\", \"name\",\"geom\") "
            + "VALUES (2, 'y', 'two', NEW ST_POINT('POINT(2 2)'));");
    run("INSERT INTO \"GeoToolsTest\".\"multi\" (\"pkey1\", \"pkey2\", \"name\",\"geom\") "
            + "VALUES (3, 'z', 'three', NEW ST_POINT('POINT(3 3)'));");
}

@Override
protected void createNullPrimaryKeyTable() throws Exception {
    run("CREATE COLUMN TABLE \"GeoToolsTest\".\"nonkey\""
            + "(\"name\" VARCHAR(255), \"geom\" ST_GEOMETRY);");

    run("INSERT INTO \"GeoToolsTest\".\"nonkey\" (\"name\") VALUES ('one');");
    run("INSERT INTO \"GeoToolsTest\".\"nonkey\" (\"name\") VALUES ('two');");
    run("INSERT INTO \"GeoToolsTest\".\"nonkey\" (\"name\") VALUES ('three');");
}

@Override
protected void createUniqueIndexTable() throws Exception {
    run("CREATE COLUMN TABLE \"GeoToolsTest\".\"uniq\""
            + "(\"pkey\" INTEGER UNIQUE, \"name\" VARCHAR(255), \"geom\" ST_GEOMETRY);");

    run("INSERT INTO \"GeoToolsTest\".\"uniq\" (\"pkey\", \"name\",\"geom\") "
            + "VALUES (1, 'one', NEW ST_POINT('POINT(1 1)'));");
    run("INSERT INTO \"GeoToolsTest\".\"uniq\" (\"pkey\", \"name\",\"geom\") "
            + "VALUES (2, 'two', NEW ST_POINT('POINT(2 2)'));");
    run("INSERT INTO \"GeoToolsTest\".\"uniq\" (\"pkey\", \"name\",\"geom\") "
            + "VALUES (3, 'three', NEW ST_POINT('POINT(3 3)'));");
}

@Override
protected void dropAutoGeneratedPrimaryKeyTable() throws Exception {
    run("DROP TABLE \"GeoToolsTest\".\"auto\"");
}

@Override
protected void dropSequencedPrimaryKeyTable() throws Exception {
}

@Override
protected void dropNonIncrementingPrimaryKeyTable() throws Exception {
    run("DROP TABLE \"GeoToolsTest\".\"noninc\"");
}

@Override
protected void dropMultiColumnPrimaryKeyTable() throws Exception {
    run("DROP TABLE \"GeoToolsTest\".\"multi\"");
}

@Override
protected void dropNullPrimaryKeyTable() throws Exception {
    run("DROP TABLE \"GeoToolsTest\".\"nokey\"");
}

@Override
protected void dropUniqueIndexTable() throws Exception {
    run("DROP TABLE \"GeoToolsTest\".\"uniq\"");
}

@Override
protected void dropNonFirstPrimaryKeyTable() throws Exception {

}

@Override
protected void createNonFirstColumnPrimaryKey() throws Exception {

}
}
