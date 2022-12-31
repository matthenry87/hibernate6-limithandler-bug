package org.hibernate.bugs;

import org.hibernate.dialect.DB2Dialect;
import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.pagination.LegacyDB2LimitHandler;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;

public class CustomDb2Dialect extends DB2Dialect {

    public CustomDb2Dialect(DialectResolutionInfo info) {

        super(info);
    }

    @Override
    public LimitHandler getLimitHandler() {

        return LegacyDB2LimitHandler.INSTANCE;
    }

    @Override
    public DatabaseVersion getVersion() {
        return new DatabaseVersion() {

            @Override
            public int getDatabaseMajorVersion() {

                return 10;
            }

            @Override
            public int getDatabaseMinorVersion() {

                return 0;
            }
        };
    }

}
