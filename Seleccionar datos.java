public List<Computadora> obtenerComputadoras() {
    List<Computadora> computadoras = new ArrayList<>();
    String sql = "SELECT * FROM computadoras";
    try (Connection conn = ConexionBD.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Computadora computadora = new Computadora();
            computadora.setId(rs.getInt("id"));
            computadora.setNombre(rs.getString("nombre"));
            computadora.setPrecio(rs.getDouble("precio"));
            computadora.setCantidad(rs.getInt("cantidad"));
            computadora.setMarca(rs.getString("marca"));
            computadoras.add(computadora);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return computadoras;
}
