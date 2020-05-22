package back.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import back.dtos.ConceptoDTO;
import back.dtos.UsuarioDto;
import front.pantalla.ejecutora.ConnectionPool;

public class ConceptoDAO {

	public List<ConceptoDTO> consultaConcepto() {
		// TODO Auto-generated method stub
		List<ConceptoDTO> consultaConcepto = new LinkedList<ConceptoDTO>();
		Connection con = ConnectionPool.getConnection();
		ResultSet res = null;
		Statement stm = null;

		try {
			stm = con.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			res = stm.executeQuery("SELECT * FROM concepto ");
			while (res.next()) {
				ConceptoDTO concep = new ConceptoDTO();
				concep.setId(res.getInt(1));
				if (res.getString(3) == null) {
					concep.setDescripcion("");
				} else {
					concep.setDescripcion(res.getString(3));
				}
				concep.setTipoConcepto(res.getString(4));
				concep.setImporte(res.getInt(6));
				consultaConcepto.add(concep);
			}
			return consultaConcepto;
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta");
			e.printStackTrace();
			return null;

		} finally {
			try {
				if (res != null)
					res.close();
				if (stm != null)
					stm.close();
			} catch (SQLException e2) {
				System.out.println("Error en el finally");

				e2.printStackTrace();
				throw new RuntimeException();
			}

		}
	}

}
