public void insertarComputadora(Computadora computadora) {
    String sql = "INSERT INTO computadoras (nombre, precio, cantidad, marca) VALUES (?, ?, ?, ?)";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, computadora.getNombre());
        pstmt.setDouble(2, computadora.getPrecio());
        pstmt.setInt(3, computadora.getCantidad());
        pstmt.setString(4, computadora.getMarca());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
