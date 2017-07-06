package zalho.com.br.ilhasguide.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import zalho.com.br.ilhasguide.entities.PontoTuristico;

/**
 * Created by andrepereira on 14/06/17.
 */

public class PontoTuristicoDao extends SQLiteOpenHelper{

    public PontoTuristicoDao(Context context) {
        super(context, "PontoTuristico", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS tb_ponto_turistico ( " +
                "idPontoTuristico INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomePontoTuristico TEXT NOT NULL, " +
                "descricaoPontoTuristico TEXT NOT NULL, " +
                "imagePathPontoTuristico TEXT NOT NULL, " +
                "precoPontoTuristico REAL NOT NULL, " +
                "flFavorito INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(sql);
    }

    public void populaBanco() {
        SQLiteDatabase db = getWritableDatabase();
//        insere(new PontoTuristico("Ponte Hercilio Luz", "Ponte histórica da ilha de Santa Catarina.", "ponte.jpg", BigDecimal.valueOf(0.00)), db);
//        insere(new PontoTuristico("Praia da Joaquina", "Praia onde ocorre etapa do campeonato mundial de surf", "joaquina.jpg", BigDecimal.valueOf(0.00)), db);
//        insere(new PontoTuristico("Museu Cruz e Souza", "Museu histórico sobre fundação de Florianópolis", "museu.jpg", BigDecimal.valueOf(15.00)), db);
//        insere(new PontoTuristico("Igreja do Centro", "Igreja no centro de Floripa", "igreja.jpg", BigDecimal.valueOf(0.00)), db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insere(PontoTuristico pontoTuristico){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nomePontoTuristico", pontoTuristico.getNomePT());
        dados.put("descricaoPontoTuristico", pontoTuristico.getDescricaoPT());
        dados.put("imagePathPontoTuristico", pontoTuristico.getImagePathPT());
        dados.put("precoPontoTuristico", String.valueOf(pontoTuristico.getPrecoPT()));
        dados.put("flFavorito", (pontoTuristico.isFavorito()) ? 1 : 0);
        db.insert("tb_ponto_turistico", null, dados);
        db.close();
    }

    private void insere(PontoTuristico pontoTuristico, SQLiteDatabase db){

        ContentValues dados = pegaDadosPontoTuristico(pontoTuristico);
        db.insert("tb_ponto_turistico", null, dados);
        db.close();
    }

    private void remove(int idPontoTuristico){
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {String.valueOf(idPontoTuristico)};
        db.delete("tb_ponto_turistico", "idPontoTuristico = ?", params);
    }

    public PontoTuristico getById(int idPontoTuristico){
        String sql = "Select * from tb_ponto_turistico where idPontoTuristico = ?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(idPontoTuristico)});

        PontoTuristico pontoTuristico = new PontoTuristico();

        if (cursor.moveToNext()){
            pontoTuristico.setIdPT(cursor.getInt(cursor.getColumnIndex("idPontoTuristico")));
            pontoTuristico.setNomePT(cursor.getString(cursor.getColumnIndex("nomePontoTuristico")));
            pontoTuristico.setDescricaoPT(cursor.getString(cursor.getColumnIndex("descricaoPontoTuristico")));
            pontoTuristico.setImagePathPT(cursor.getString(cursor.getColumnIndex("imagePathPontoTuristico")));
            pontoTuristico.setPrecoPT(BigDecimal.valueOf(cursor.getInt(cursor.getColumnIndex("precoPontoTuristico"))));
        }
        cursor.close();

        return pontoTuristico;
    }

    public List<PontoTuristico> getFavorites() {
        String sql = "Select * from tb_ponto_turistico where flFavorito = 1";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<PontoTuristico> favoritos = new ArrayList<>();

        while (cursor.moveToNext()){
            PontoTuristico pontoTuristico = new PontoTuristico();
            pontoTuristico.setIdPT(cursor.getInt(cursor.getColumnIndex("idPontoTuristico")));
            pontoTuristico.setNomePT(cursor.getString(cursor.getColumnIndex("nomePontoTuristico")));
            pontoTuristico.setDescricaoPT(cursor.getString(cursor.getColumnIndex("descricaoPontoTuristico")));
            pontoTuristico.setImagePathPT(cursor.getString(cursor.getColumnIndex("imagePathPontoTuristico")));
            pontoTuristico.setPrecoPT(BigDecimal.valueOf(cursor.getInt(cursor.getColumnIndex("precoPontoTuristico"))));
            pontoTuristico.setFavorito(cursor.getInt(cursor.getColumnIndex("flFavorito")) == 1);
            favoritos.add(pontoTuristico);
        }
        cursor.close();

        return favoritos;
    }

    public List<PontoTuristico> getAll(){
        String sql = "Select * from tb_ponto_turistico";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<PontoTuristico> pontoTuristicos = new ArrayList<>();

        while (cursor.moveToNext()){
            PontoTuristico pontoTuristico = new PontoTuristico();
            pontoTuristico.setIdPT(cursor.getInt(cursor.getColumnIndex("idPontoTuristico")));
            pontoTuristico.setNomePT(cursor.getString(cursor.getColumnIndex("nomePontoTuristico")));
            pontoTuristico.setDescricaoPT(cursor.getString(cursor.getColumnIndex("descricaoPontoTuristico")));
            pontoTuristico.setImagePathPT(cursor.getString(cursor.getColumnIndex("imagePathPontoTuristico")));
            pontoTuristico.setPrecoPT(new BigDecimal(cursor.getString(cursor.getColumnIndex("precoPontoTuristico"))));
            pontoTuristico.setFavorito(cursor.getInt(cursor.getColumnIndex("flFavorito")) == 1);
            pontoTuristicos.add(pontoTuristico);
        }
        cursor.close();

        return pontoTuristicos;
    }

    public void dropTable(){
        String sql = "Drop table tb_ponto_turistico";

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public boolean addToFavirotes(PontoTuristico pontoTuristico){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values;
        values = pegaDadosPontoTuristico(pontoTuristico);
        String[] id = {String.valueOf(pontoTuristico.getIdPT())};
        try{
            db.update("tb_ponto_turistico", values, "idPontoTuristico = ?", id);
            db.close();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private ContentValues pegaDadosPontoTuristico(PontoTuristico pontoTuristico) {
        if(pontoTuristico.getImagePathPT() == null || "".equals(pontoTuristico.getImagePathPT())){
            pontoTuristico.setImagePathPT("none");
        }
        ContentValues dados = new ContentValues();
        dados.put("nomePontoTuristico", pontoTuristico.getNomePT());
        dados.put("descricaoPontoTuristico", pontoTuristico.getDescricaoPT());
        dados.put("imagePathPontoTuristico", pontoTuristico.getImagePathPT());
        dados.put("precoPontoTuristico", String.valueOf(pontoTuristico.getPrecoPT()));
        dados.put("idPontoTuristico", String.valueOf(pontoTuristico.getIdPT()));
        dados.put("flFavorito", (pontoTuristico.isFavorito()) ? 1 : 0);

        return dados;
    }
}
