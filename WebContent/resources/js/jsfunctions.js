function showProductsForCategory(categoryId){
	var tableRows = document.getElementById("productsTable").rows;
	  for (var i = 0; i < tableRows.length; i++){
		  if(tableRows[i].className == categoryId){
			  tableRows[i].style.display = 'table-row';
		  }else{
			  tableRows[i].style.display = 'none';
		  }
	  }
}

function addProductToCart(productId){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("status").innerHTML = this.responseText;
	    }
	  };
	  request.open("GET", "CartServlet?productId=" + productId, true);
	  request.send();
}