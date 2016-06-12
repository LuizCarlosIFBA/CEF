<%-- 
    Document   : formularioCadastro
    Created on : 02/05/2016, 21:59:55
    Author     : Catí
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="InserirCadastro.jsp" method ="post">
               <h1>Cadastro</h1>
               <h3>Insira os dados do usuário</h3>
                
               <!--Cadastro-->
		<table>
			<tr>
				<td><b>Login:</b></td><td><input type=text size=50 name="Login"></td>
			</tr>
                        
                        <tr>
				<td><b>Senha:</b></td><td><input type=text size=50 name="Senha"></td>
                        </tr>
                        
			<tr>
                            <td colspan=2 align=left><input type=submit value="Excluir cadastro"></td><td colspan=2 align=right><input type=submit value="Cadastrar"></td>
                        </tr>
	        </table>
        </form>
    </body>
</html>
