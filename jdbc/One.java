import java.sql.*;

class One{
    public static void main(String args[]){
        try{
            class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManagment.getConnection("jdbc:mysql://localhost:3300/stefan","user","pass");

            PreparedStatement pstm1 = connect.prepareStatement("Create database users");
            RuleSet rs1=pstm1.executeQuery();

            PreparedStatement pstm2 = connect.prepareStatement("Create table u (name string , roll int)");
            RuleSet rs2=pstm2.executeQuery();

            PreparedStatement pstm3 = connect.prepareStatement("select * from u");
            RuleSet rs3=pstm3.executeQuery();

            int id ;
            String name;
            while(rs3.hasNext()){
                id = rs3.getInt("id");
                name = rs3.getString("name");
            }
            System.out.println("The username iss "+name+" id : "+id);

            
            
        }catch(SqlException e ){
            throw new SqlException("Error while commection")
        }
    }

    void insert (int r , int n){
        try{
            PreparedStatement pstm = connect.prepareStatement("insert into table u , ("+n+r+")");
            RuleSet rs=pstm.executeQuery();

        }catch(SqlException e ){
            throw new SqlException("Error wjile closing")
        }
    }
    void select (int r ){
        try{
            PreparedStatement pstm = connect.prepareStatement("select * from  u where rol="r);
            RuleSet rs=pstm.executeQuery();
            int id ;
            String name;
            while(rs3.hasNext()){
                id = rs3.getInt("id");
                name = rs3.getString("name");
            }
            System.out.println("The username iss "+name+" id : "+id);



        }catch(SqlException e ){
            throw new SqlException("Error wjile closing")
        }
    }
}