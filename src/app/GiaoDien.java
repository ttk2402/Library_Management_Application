package app;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author trant
 */
public class GiaoDien extends javax.swing.JFrame {

    private ConnectionDB connectDB;
    private Connection connect;

    /**
     * Creates new form GiaoDien
     */
    public GiaoDien() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Ứng dụng quản lý thư viện");
        connectDB = new ConnectionDB(
                "jdbc:mysql://localhost:3306/quanlythuvien1",
                "root",
                "");
        connect = connectDB.getConnection();
        setLayOutTable();
        loadDataToTableBook();
        loadDataToTableBorrow();
        loadDataToTableReader();
        loadDataToCombobox();
    }

    public void setInstanceLogin(String instanceLogin) {
        lbInstanceLogin.setText(instanceLogin);

    }

    public void setLayOutTable() {
        JTableHeader headerTBSach = tbSach.getTableHeader();
        JTableHeader headerTBMuon = tbMuon.getTableHeader();
        JTableHeader headerTBDocGia = tbDocGia.getTableHeader();
        headerTBSach.setFont(new Font("Arial", Font.BOLD, 15));
        headerTBMuon.setFont(new Font("Arial", Font.BOLD, 15));
        headerTBDocGia.setFont(new Font("Arial", Font.BOLD, 15));
    }

    public void loadDataToTableBook() {
        //Load data for Books table
        DefaultTableModel model_books = (DefaultTableModel) tbSach.getModel();
        try {
            Statement st_books = connect.createStatement();
            ResultSet rs_books = st_books.executeQuery("select a.masach, a.tensach, a.tacgia, b.tentheloai, c.tennxb from sach a, theloai b, nxb c where a.matheloai=b.matheloai and a.manxb=c.manxb order by a.masach;");
            while (rs_books.next()) {
                model_books.addRow(new Object[]{rs_books.getString(1),
                    rs_books.getString(2),
                    rs_books.getString(3),
                    rs_books.getString(4),
                    rs_books.getString(5)});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public void loadDataToTableBorrow() {
        //Load data for borrow book table
        DefaultTableModel model_borrows = (DefaultTableModel) tbMuon.getModel();
        try {
            Statement st_borrows = connect.createStatement();
            ResultSet rs_borrows = st_borrows.executeQuery("select mamuon, madocgia, ngaymuon, ngaytra from muon;");
            while (rs_borrows.next()) {
                model_borrows.addRow(new Object[]{rs_borrows.getString(1),
                    rs_borrows.getString(2),
                    rs_borrows.getString(3),
                    rs_borrows.getString(4)});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void loadDataToTableReader() {      
        //Load data for readers table
        DefaultTableModel model_readers = (DefaultTableModel) tbDocGia.getModel();
        try {
            Statement st_readers = connect.createStatement();
            ResultSet rs_readers = st_readers.executeQuery("select * from docgia;");
            while (rs_readers.next()) {
                model_readers.addRow(new Object[]{rs_readers.getString(1),
                    rs_readers.getString(2),
                    rs_readers.getString(3),
                    rs_readers.getString(4)});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadDataToCombobox() {
        cbbTheLoai.addItem("Tất cả");
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("select tentheloai from theloai;");
            while (rs.next()) {
                cbbTheLoai.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbInstanceLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbbTheLoai = new javax.swing.JComboBox<>();
        btnLietKe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        btnThemSach = new javax.swing.JButton();
        btnSuaSach = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCapNhatSach = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMuon = new javax.swing.JTable();
        btnThemMuon = new javax.swing.JButton();
        btnXoaMuon = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        btnSuaMuon = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDocGia = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 51));
        jLabel1.setText("ỨNG DỤNG QUẢN LÝ THƯ VIỆN");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Phiên bản 1.0");

        lbInstanceLogin.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lbInstanceLogin.setForeground(new java.awt.Color(102, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbInstanceLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbInstanceLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hệ thống", jPanel1);

        cbbTheLoai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cbbTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTheLoaiActionPerformed(evt);
            }
        });

        btnLietKe.setBackground(new java.awt.Color(255, 204, 204));
        btnLietKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLietKe.setText("Liệt kê");
        btnLietKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLietKeActionPerformed(evt);
            }
        });

        tbSach.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản"
            }
        ));
        tbSach.setShowGrid(false);
        jScrollPane2.setViewportView(tbSach);

        btnThemSach.setBackground(new java.awt.Color(0, 153, 153));
        btnThemSach.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThemSach.setText("Thêm sách");
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnSuaSach.setBackground(new java.awt.Color(0, 153, 153));
        btnSuaSach.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSuaSach.setText("Chỉnh sửa");
        btnSuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSachActionPerformed(evt);
            }
        });

        btnXoaSach.setBackground(new java.awt.Color(0, 153, 153));
        btnXoaSach.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXoaSach.setText("Xóa sách");
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Thể loại");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setText("Kho sách");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book.png"))); // NOI18N

        btnCapNhatSach.setBackground(new java.awt.Color(0, 153, 153));
        btnCapNhatSach.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCapNhatSach.setText("Tải lại");
        btnCapNhatSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThemSach)
                .addGap(74, 74, 74)
                .addComponent(btnSuaSach)
                .addGap(72, 72, 72)
                .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btnCapNhatSach, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addComponent(btnLietKe, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLietKe))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaSach)
                    .addComponent(btnThemSach)
                    .addComponent(btnXoaSach)
                    .addComponent(btnCapNhatSach))
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Quản lý sách", jPanel2);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("Danh sách mượn");

        tbMuon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mượn", "Mã đọc giả", "Ngày mượn", "Ngày trả"
            }
        ));
        jScrollPane3.setViewportView(tbMuon);

        btnThemMuon.setBackground(new java.awt.Color(0, 153, 153));
        btnThemMuon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThemMuon.setText("Thêm ");
        btnThemMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMuonActionPerformed(evt);
            }
        });

        btnXoaMuon.setBackground(new java.awt.Color(0, 153, 153));
        btnXoaMuon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXoaMuon.setText("Xóa");
        btnXoaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMuonActionPerformed(evt);
            }
        });

        btnXemChiTiet.setBackground(new java.awt.Color(0, 153, 153));
        btnXemChiTiet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnSuaMuon.setBackground(new java.awt.Color(0, 153, 153));
        btnSuaMuon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSuaMuon.setText("Cập nhật ");
        btnSuaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMuonActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/borrow.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnThemMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnSuaMuon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnXemChiTiet)
                .addGap(93, 93, 93))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaMuon)
                    .addComponent(btnXemChiTiet)
                    .addComponent(btnSuaMuon)
                    .addComponent(btnThemMuon))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý mượn trả sách", jPanel3);

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Đăng ký");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 153, 153));
        jButton12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton12.setText("Chính sửa");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        tbDocGia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đọc giả", "Tên đọc giả", "Email", "Số điện thoại"
            }
        ));
        jScrollPane1.setViewportView(tbDocGia);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("Danh sách bạn đọc");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/read.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jButton12)
                        .addGap(96, 96, 96)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("Quản lý bạn đọc", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSachActionPerformed
        // TODO add your handling code here:
        GiaoDien g = new GiaoDien();
        g.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCapNhatSachActionPerformed

    private void btnLietKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLietKeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbSach.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        String theloai = (String) cbbTheLoai.getSelectedItem();
        if (theloai.equals("Tất cả")) {
            loadDataToTableBook();
        } else {
            String sql = "select a.masach, a.tensach, a.tacgia, b.tentheloai, c.tennxb from sach a, theloai b, nxb c where a.matheloai=b.matheloai and a.manxb=c.manxb and tentheloai='" + theloai + "' order by a.masach;";
            try {
                Statement st_books = connect.createStatement();
                ResultSet rs_books = st_books.executeQuery(sql);
                while (rs_books.next()) {
                    model.addRow(new Object[]{rs_books.getString(1),
                    rs_books.getString(2),
                    rs_books.getString(3),
                    rs_books.getString(4),
                    rs_books.getString(5)});
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnLietKeActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        XemChiTietMuon g = new XemChiTietMuon();
        g.setVisible(true);
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        // TODO add your handling code here:
        XoaSach xoasach = new XoaSach();
        xoasach.setVisible(true);
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnSuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSachActionPerformed
        // TODO add your handling code here:
        SuaSach s = new SuaSach();
        s.setVisible(true);
    }//GEN-LAST:event_btnSuaSachActionPerformed

    private void btnThemMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMuonActionPerformed
        // TODO add your handling code here:
        ThemMuon themmuon = new ThemMuon();
        themmuon.setVisible(true);
    }//GEN-LAST:event_btnThemMuonActionPerformed

    private void btnSuaMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMuonActionPerformed
        // TODO add your handling code here:
        CapNhatMuon suamuon = new CapNhatMuon();
        suamuon.setVisible(true);
    }//GEN-LAST:event_btnSuaMuonActionPerformed

    private void btnXoaMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMuonActionPerformed
        // TODO add your handling code here:
        XoaMuon xoamuon = new XoaMuon();
        xoamuon.setVisible(true);
    }//GEN-LAST:event_btnXoaMuonActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        SuaDG s = new SuaDG();
        s.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DangKyDG d = new DangKyDG();
        d.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        XoaDG x = new XoaDG();
        x.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        // TODO add your handling code here:
        ThemSach t = new ThemSach();
        t.setVisible(true);
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void cbbTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTheLoaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatSach;
    private javax.swing.JButton btnLietKe;
    private javax.swing.JButton btnSuaMuon;
    private javax.swing.JButton btnSuaSach;
    private javax.swing.JButton btnThemMuon;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXoaMuon;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbInstanceLogin;
    private javax.swing.JTable tbDocGia;
    private javax.swing.JTable tbMuon;
    private javax.swing.JTable tbSach;
    // End of variables declaration//GEN-END:variables
}
