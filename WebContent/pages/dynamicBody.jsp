<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>Categories:</p>
<table id="categoriesTable">
	<tr>
		<c:forEach items="${sessionScope.categories}" var="category">
			<td>
				<button type="button" onclick="javascript:showProductsForCategory(${category.id})">
					<c:out value="${category}" />
				</button>
			</td>
		</c:forEach>
	</tr>
</table>

<p>Products:</p>
<table id="productsTable">
	<c:forEach items="${sessionScope.products}" var="product">
		<tr class="${product.categoryId}" style="display: none">
			<td><c:out value="${product}" />
				<button type="button" onclick="javascript:addProductToCart(${product.id})">Add to cart</button></td>
		</tr>
	</c:forEach>
</table>

<p id="status">