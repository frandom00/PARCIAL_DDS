import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper {


        private String nombre;
        private String contra;
        private int plata;
        private int suscrip;

        public UsuarioMapper(String nombre, String contra,int suscrip, int plata) {
            this.nombre = nombre;
            this.contra = contra;
            this.plata = plata;
            this.suscrip = suscrip;
        }

        public int insert() {
            UsuarioDAO personaDAO = new UsuarioDAO();
            return personaDAO.insert(this.nombre, this.contra, this.suscrip, this.plata);
        }

}
