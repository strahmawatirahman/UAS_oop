import java.sql.*;
import java.util.*;

public class ProfileImpl implements ProfileServices {

    @Override
    public Profil insert(Profil profil) throws SQLException {
        PreparedStatement stm = KoneksiDb.getConnection().prepareStatement("insert into anggota values(?,?,?,?,?,?)");
        stm.setInt(1, profil.getStb());
        stm.setString(2, profil.getNama());
        stm.setString(3, profil.getFakultas());
        stm.setString(4, profil.getAlamat());
        stm.setString(5, profil.getTelp());
        stm.setString(6, profil.getEmail());
        stm.executeUpdate();

        return profil;
    }

    @Override
    public void update(Profil profil) throws SQLException {
        PreparedStatement stm = KoneksiDb.getConnection().prepareStatement("update anggota set nama=?,fakultas=?,alamat=?,telp=?,email=? where stb=?");

        stm.setString(1, profil.getNama());
        stm.setString(2, profil.getFakultas());
        stm.setString(3, profil.getAlamat());
        stm.setString(4, profil.getTelp());
        stm.setString(5, profil.getEmail());
        stm.setInt(6, profil.getStb());
        stm.executeUpdate();

    }

    @Override
    public void delete(int stb) throws SQLException {
        PreparedStatement stm = KoneksiDb.getConnection().prepareStatement("delete from anggota  where stb=?");
        stm.setInt(1, stb);
        stm.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement stm = KoneksiDb.getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select * from anggota");
        List list = new ArrayList();
        while (rst.next()) {
            Profil p = new Profil();
            p.setStb(rst.getInt("stb"));
            p.setNama(rst.getString("nama"));
            p.setNama(rst.getString("fakultas"));
            p.setAlamat(rst.getString("alamat"));
            p.setTelp(rst.getString("telp"));
            p.setNama(rst.getString("email"));
            list.add(p);
        }
        return list;
    }
}
