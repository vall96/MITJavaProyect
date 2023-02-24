package View;

/**
 *
 * @author vrodriguez
 */
public class Inventory extends javax.swing.JFrame {

    /**
     * Creates new form Inventory
     */
    public Inventory() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel8 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        lblCode = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        btnConsult = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblInfoGen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCode1 = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescription1 = new javax.swing.JTextField();
        lblPrecioCosto = new javax.swing.JLabel();
        txtPriceCost = new javax.swing.JTextField();
        lblGanancia = new javax.swing.JLabel();
        txtProfit = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtCurrency = new javax.swing.JTextField();
        lblMoneda = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        txtTotalProfit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        dtxFecha = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        lblNroArtTotal = new javax.swing.JLabel();
        lblFechasCons = new javax.swing.JLabel();
        lblTcostos = new javax.swing.JLabel();
        lblTventas = new javax.swing.JLabel();
        lblTganancias = new javax.swing.JLabel();

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("jLabel14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Inventario");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(lblTitulo)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        jToolBar2.setFloatable(false);

        btnAdd.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd.setText("F5 Agregar");
        btnAdd.setAlignmentY(1.0F);
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setMaximumSize(new java.awt.Dimension(70, 60));
        btnAdd.setMinimumSize(new java.awt.Dimension(70, 60));
        btnAdd.setName(""); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(70, 60));
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnAdd);

        btnEdit.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        btnEdit.setText("F6 Editar");
        btnEdit.setAlignmentY(1.0F);
        btnEdit.setBorder(null);
        btnEdit.setBorderPainted(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setMaximumSize(new java.awt.Dimension(70, 60));
        btnEdit.setMinimumSize(new java.awt.Dimension(70, 60));
        btnEdit.setName(""); // NOI18N
        btnEdit.setPreferredSize(new java.awt.Dimension(70, 60));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnEdit);

        btnSave.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnSave.setText("F7 Guardar");
        btnSave.setAlignmentY(1.0F);
        btnSave.setBorder(null);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMaximumSize(new java.awt.Dimension(70, 60));
        btnSave.setMinimumSize(new java.awt.Dimension(70, 60));
        btnSave.setName(""); // NOI18N
        btnSave.setPreferredSize(new java.awt.Dimension(70, 60));
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnSave);

        btnDelete.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bin.png"))); // NOI18N
        btnDelete.setText("F8 Eliminar");
        btnDelete.setAlignmentY(1.0F);
        btnDelete.setBorder(null);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setMaximumSize(new java.awt.Dimension(70, 60));
        btnDelete.setMinimumSize(new java.awt.Dimension(70, 60));
        btnDelete.setName(""); // NOI18N
        btnDelete.setPreferredSize(new java.awt.Dimension(70, 60));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnDelete);

        btnCancel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/undo.png"))); // NOI18N
        btnCancel.setText("F9 Descartar");
        btnCancel.setAlignmentY(1.0F);
        btnCancel.setBorder(null);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setMaximumSize(new java.awt.Dimension(70, 60));
        btnCancel.setMinimumSize(new java.awt.Dimension(70, 60));
        btnCancel.setName(""); // NOI18N
        btnCancel.setPreferredSize(new java.awt.Dimension(70, 60));
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnCancel);

        getContentPane().add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Buscar");

        lblCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCode.setForeground(new java.awt.Color(0, 0, 0));
        lblCode.setText("Código");

        lblDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(0, 0, 0));
        lblDescription.setText("Descripción");

        txtCode.setMaximumSize(new java.awt.Dimension(64, 22));

        txtDescription.setMaximumSize(new java.awt.Dimension(64, 22));

        btnConsult.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(lblCode))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch)
                        .addGap(73, 73, 73))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsult)
                    .addComponent(btnSearch))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 640, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblInfoGen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfoGen.setText("Información General");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoGen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblInfoGen))
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigo.setText("Codigo");

        txtCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCode1ActionPerformed(evt);
            }
        });

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setText("Descripcion");

        txtDescription1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescription1ActionPerformed(evt);
            }
        });

        lblPrecioCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPrecioCosto.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecioCosto.setText("Precio Costo");

        txtPriceCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceCostActionPerformed(evt);
            }
        });

        lblGanancia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGanancia.setForeground(new java.awt.Color(0, 0, 0));
        lblGanancia.setText("% Ganancia");

        txtProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfitActionPerformed(evt);
            }
        });

        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });

        txtCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrencyActionPerformed(evt);
            }
        });

        lblMoneda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMoneda.setForeground(new java.awt.Color(0, 0, 0));
        lblMoneda.setText("Moneda");

        lblProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProveedor.setForeground(new java.awt.Color(0, 0, 0));
        lblProveedor.setText("Proveedor");

        lblCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(0, 0, 0));
        lblCategoria.setText("Categoria");

        lblUbicacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUbicacion.setForeground(new java.awt.Color(0, 0, 0));
        lblUbicacion.setText("Ubicacion");

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        txtTotalProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalProfitActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText(".");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("IVA%");

        txtIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIVAActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("% Desc");

        txtTotalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCostActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Fecha");

        txtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierActionPerformed(evt);
            }
        });

        txtLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(lblCodigo)
                    .addComponent(lblPrecioCosto)
                    .addComponent(lblGanancia))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPriceCost, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUbicacion)
                            .addComponent(lblCategoria)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProveedor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMoneda, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCategory)
                    .addComponent(txtCurrency)
                    .addComponent(txtLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(txtSupplier))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCodigo)
                                .addComponent(txtCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))
                            .addComponent(dtxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(txtDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioCosto)
                            .addComponent(txtPriceCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGanancia)
                            .addComponent(txtProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUbicacion)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProveedor)
                            .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMoneda)
                            .addComponent(txtCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 640, 190));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNroArtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNroArtTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblNroArtTotal.setText("Nº de Articulos");

        lblFechasCons.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechasCons.setForeground(new java.awt.Color(0, 0, 0));
        lblFechasCons.setText("a la fecha:");

        lblTcostos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTcostos.setForeground(new java.awt.Color(0, 0, 0));
        lblTcostos.setText("Costos:");

        lblTventas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTventas.setForeground(new java.awt.Color(0, 0, 0));
        lblTventas.setText("Ventas:");

        lblTganancias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTganancias.setForeground(new java.awt.Color(0, 0, 0));
        lblTganancias.setText("Ganancias:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNroArtTotal)
                    .addComponent(lblFechasCons))
                .addGap(201, 201, 201)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTganancias)
                    .addComponent(lblTventas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTcostos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNroArtTotal)
                    .addComponent(lblTcostos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechasCons)
                    .addComponent(lblTventas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTganancias)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 640, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationActionPerformed

    private void txtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierActionPerformed

    private void txtTotalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCostActionPerformed

    private void txtIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVAActionPerformed

    private void txtTotalProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalProfitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalProfitActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrencyActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfitActionPerformed

    private void txtPriceCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceCostActionPerformed

    private void txtDescription1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescription1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescription1ActionPerformed

    private void txtCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCode1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dtxFecha;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFechasCons;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblInfoGen;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblNroArtTotal;
    private javax.swing.JLabel lblPrecioCosto;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTcostos;
    private javax.swing.JLabel lblTganancias;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTventas;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCode1;
    private javax.swing.JTextField txtCurrency;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtDescription1;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtPriceCost;
    private javax.swing.JTextField txtProfit;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtTotalCost;
    private javax.swing.JTextField txtTotalProfit;
    // End of variables declaration//GEN-END:variables
}
