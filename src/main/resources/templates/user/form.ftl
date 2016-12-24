<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="/layouts/layout">
 
<body>
	<section layout:fragment="content">
		<div class="titre"> <i class="fa fa-plus"></i>
		   <#if !userForm.id??>
			   Nouvel utilisateur
			<#else>
			   Edition de l'utilisateur
			   ${userForm.lastName}
			   ${userForm.firstName}
		   </#if> 
		</div>
		<#-- 	<ul th:if="${not #lists.isEmpty(erreurs)}">
				<li th:each="erreur : ${erreurs}" >
				 <span th:text="${erreur.key}"></span> : <span th:text="${erreur.value}"></span>
				</li>
     	 	</ul>  
		 
		<form action="#" th:action="@{/user/save}" th:object="${userForm}" method="post">
            <table class="table">
                <tr>
                    <td>Nom:</td>
                    <td><input type="text" th:field="*{lastName}" /></td>
                    <td th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}">Erreur de nom</td>
                </tr>
                <tr>
                    <td>Pr�nom:</td>
                    <td><input type="text" th:field="*{firstName}" /></td>
                    <td th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}">Erreur de pr�nom</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" th:field="*{email}" /></td>
                    <td th:if="${#fields.hasErrors('email')}" th:errors="*{email}">Erreur d'email</td>
                </tr>
                
                <tr>
                    <td>Login:</td>
                    <td><input type="text" th:field="*{login}" /></td>
                    <td th:if="${#fields.hasErrors('login')}" th:errors="*{login}">Erreur login</td>
                </tr>
                
                <tr>
                    <td>Mot de passe:</td>
                    <td><input type="password" th:field="*{password}" /></td>
                    <td th:if="${#fields.hasErrors('password')}" th:errors="*{password}">Erreur mot de passe</td>
                </tr>
                <tr>
                    <td><button class="btn-blue" type="submit">Enregistrer <i class="fa fa-save"></i> </button></td>
                </tr>
            </table>
        </form>
        -->
	</section>
	<footer>
		<p layout:fragment="custom-footer"> 
		  footer content from child!
		</p>
	</footer>
</body>
</html>