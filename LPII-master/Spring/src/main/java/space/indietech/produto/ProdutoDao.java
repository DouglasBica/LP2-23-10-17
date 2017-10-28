package space.indietech.produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
@Component
public class ProdutoDao {

	private JdbcTemplate jdbc;

	@Autowired
	// marcando o contrutor;
	public ProdutoDao(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void adicionaProduto(Produto produto) {
		jdbc.update("INSERT INTO produtos (nome,valor,codigo) values (?,?,?,)", produto.getNome(), produto.getValor(),
				produto.getCodigo());
	}

	public List<Produto> getListaProdutos() {
		List<Produto> produtos = jdbc.query("SELECT * FROM produtos ", new RowMapper<Produto>() {
			@Override
			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produto produto = new Produto();

				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));

				return produto;
			}
		});
		return produtos;
	}

	//private List<Produto> produtos = new ArrayList<Produto>();
	public void delete(long codigo) {
		jdbc.update("DELETE FROM produtos WHERE codigo = ?", codigo);

	}

}
