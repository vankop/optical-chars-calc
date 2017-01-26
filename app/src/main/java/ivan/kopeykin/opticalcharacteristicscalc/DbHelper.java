package ivan.kopeykin.opticalcharacteristicscalc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Developer on 26.01.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String REAl_TYPE = " REAL";
    private static final String COMMA_SEP = ",";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OpticalCharacteristicsCalc.db";
    private static final String TABLE_NAME = "Cables";
    private static final String _ID = "Id";
    private static final String COLUMN_NAME_MARK = "Mark";
    private static final String COLUMN_NAME_L = "Length";
    private static final String COLUMN_NAME_L0 = "LengthZero";
    private static final String COLUMN_NAME_S0 = "S";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DbHelper.TABLE_NAME + " (" +
                    DbHelper._ID + " INTEGER PRIMARY KEY," +
                    DbHelper.COLUMN_NAME_MARK + TEXT_TYPE + COMMA_SEP +
                    DbHelper.COLUMN_NAME_L + REAl_TYPE + COMMA_SEP +
                    DbHelper.COLUMN_NAME_L0 + REAl_TYPE + COMMA_SEP +
                    DbHelper.COLUMN_NAME_S0 + REAl_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DbHelper.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
