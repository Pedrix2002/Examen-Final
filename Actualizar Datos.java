public void actualizarComputadora(Computadora computadora) {
    String sql = "UPDATE computadoras SET nombre = ?, precio = ?, cantidad = ?, marca = ? WHERE id = ?";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, computadora.getNombre());
        pstmt.setDouble(2, computadora.getPrecio());
        pstmt.setInt(3, computadora.getCantidad());
        pstmt.setString(4, computadora.getMarca());
        pstmt.setInt(5, computadora.getId());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
