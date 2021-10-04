<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="shared/header.jsp"%>
<div id="container">
    <header id="main-header">
        <div id="name-user">Ларионов Анатолий</div>
        <div id="a-exit"><a href="auth">Выход</a></div>
<%--        <c:if test="${role.name == 'ADMIN'}">
            <div id="add-item"><a href="<c:url value="/admin"/>">Добавить товар</a></div>
        </c:if>--%>
        <div><a href="/">Назад</a></div>
        <%@include file="search.jsp"%>
        <%@include file="basket.jsp"%>

    </header>
    <section class="main-section">
    <c:forEach items="${categories}" var="category">
            <div>${category.nameCategory}</div>

        <br>
        <br>
        <br>
        <table>
            <tr>
                <th>Описание</th>
                <th>Производитель</th>
                <th>Название</th>
                <th>Цена</th>
                <th>Категория</th>
                <th>Добавить</th>
            </tr>
            <tr>
                <form action="<c:url value="/admin/add"/>" method="post">
                    <td>
                        <input type="text" name="description" id="description-p" placeholder="Описание продукта" required>
                    </td>
                    <td>
                        <input type="number" name="manufacturer" id="manufacturer" placeholder="Производитель" required>
                    </td>
                    <td>
                        <input type="text" name="nameProduct" id="name-p" placeholder="Название продукта" required>
                    </td>
                    <td>
                        <input type="number" name="price" id="price-p" placeholder="Цена продукта" required>
                    </td>
                    <td>
                        <input type="number" name="category" id="category-p" placeholder="Категория" required>
                    </td>
                    <td>
                        <input id="add-btn-product" type="submit" value="Добавить">
                    </td>
                </form>
            </tr>
            <c:forEach items="${category.products}" var="prod">
                <tr>
                    <form action="admin/edit" method="post">
                        <td><input type="text" name="nameProduct" id="name" placeholder="Название продукта" value = "${prod.nameProduct}"/></td>
                        <td><input type="text" name="price" id="cost" placeholder="Цена" value = "${prod.price}"/></td>
                        <td><input type="text" name="description" id="description"  placeholder="Описание продукта" value = "${prod.description}"/></td>
                        <%--<td><input type="text" name="manufacturer" id="manufacturer-m"  placeholder="Производитель" value = "${manufacturer}"/></td>--%>
                        <td>
                            <input id="update-product" type="submit" value="Изменить">
                        </td>
                    </form>
                    <td>
                        <a href="admin/delete/${prod.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </c:forEach>
</div>
<%@include file="shared/footer.jsp"%>
