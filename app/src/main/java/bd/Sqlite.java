package bd;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite extends SQLiteOpenHelper{
    @Override

    //Script de criação do BD (Não testado)
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE produto("  +
                "codigo integer primary key autoincrement," +
                "nomeProduto VARCHAR(50) NOT NULL," +
                "valorProduto DOUBLE NOT NULL," +
                "qtdMinima INT DEFAULT '1')";

        db.execSQL(sql);
    }

    //Criação do BD
    public Sqlite(Context context){
        super(context, "estoque", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS produto");
        onCreate(db);
    }
}
