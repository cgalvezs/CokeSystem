package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.text.DateFormat;
import java.util.Date;

import cl.ciisa.cokedb.dao.interfaces.IMovimientosDAO;
import cl.ciisa.cokedb.model.MovimientosBeans;
import cl.ciisa.cokedb.model.PalletsBeans;
import cl.ciisa.cokedb.model.UsuarioBeans;
import cl.ciisa.cokedb.resources.Resources;

public class MovimientosDAO implements IMovimientosDAO {

	private Connection con = null;
	private ResourceBundle sql = null;

	public MovimientosDAO(Connection conn) {
		this.con = conn;
		this.sql = InitResource.getSQLResource(Resources.getApplication());
	}

	public ArrayList<MovimientosBeans> getAll() throws DAOException {
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql
					.getString("SELECT_MOVIMIENTOS_ALL"));

			ResultSet rs = stmt.executeQuery();
			ArrayList<MovimientosBeans> lstMovimientos = new ArrayList<MovimientosBeans>();
			while (rs.next()) {

				MovimientosBeans movimientosBean = new MovimientosBeans();

				// SELECT ID_MOVIMIENTO, IDTIPO_MOVIMIENTO, IDUSUARIOS,
				// IDUNICO_MOVIMIENTOS, IDUNICO_PRODUCTOS, DATE,
				// PALLETS_IDPALLET FROM MOVIMIENTOS
				movimientosBean.setIdMovimiento(rs.getInt(1));
				movimientosBean.setIdTipoMovimiento(rs.getInt(2));
				movimientosBean.setIdUsuario(rs.getInt(3));
				movimientosBean.setIdUnicoMovimientos(rs.getInt(4));
				movimientosBean.setIdUnicoProductos(rs.getInt(5));
				movimientosBean.setDate(rs.getDate(6));
				movimientosBean.setPalletsIdPallet(rs.getInt(7));

				lstMovimientos.add(movimientosBean);

			}

			return lstMovimientos;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}
	
	public Integer insert(MovimientosBeans movi) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_MOVIMIENTOS"),
					Statement.RETURN_GENERATED_KEYS);
			
//INSERT INTO MOVIMIENTOS (IDTIPO_MOVIMIENTO, IDUSUARIOS, IDUNICO_MOVIMIENTOS, IDUNICO_PRODUCTOS, DATE, PALLETS_IDPALLET) VALUES (?,?,?,?,?,?,?)	
			
			pst.setInt(1, movi.getIdTipoMovimiento());
			pst.setInt(2, movi.getIdUsuario());
			pst.setInt(3, movi.getIdUnicoMovimientos());
			pst.setInt(4, movi.getIdUnicoProductos());
			pst.setDate(5, (java.sql.Date) movi.getDate());
			pst.setInt(6, movi.getPalletsIdPallet());
			
		
			
			if (pst.executeUpdate() != 1)
				throw new DAOException("No se pudo insertar la solicitud");

			generatedKeys = pst.getGeneratedKeys();
			generatedKeys.first();
			ResultSetMetaData rsmd = generatedKeys.getMetaData();
			if (rsmd.getColumnCount() > 1) {
				throw new DAOException("Se genero mas de una llave");
			}
			
			//con.commit();
			return generatedKeys.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (generatedKeys != null)
					generatedKeys.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean update(MovimientosBeans movi) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE_MOVIMIENTOS"));

//UPDATE MOVIMIENTOS SET IDTIPO_MOVIMIENTO = ?, IDUSUARIOS = ?, IDUNICO_MOVIMIENTOS = ?, IDUNICO_PRODUCTOS = ?, DATE = ?, PALLETS_IDPALET = ? WHERE ID_MOVIMIENTO = ?
			pst.setInt(1, movi.getIdTipoMovimiento());
			pst.setInt(2, movi.getIdUsuario());
			pst.setInt(3, movi.getIdUnicoMovimientos());
			pst.setInt(4, movi.getIdUnicoProductos());
			pst.setDate(5, (java.sql.Date) movi.getDate());
			pst.setInt(6, movi.getPalletsIdPallet());
			
			
			int rs = pst.executeUpdate();
			return (rs == 1);

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
