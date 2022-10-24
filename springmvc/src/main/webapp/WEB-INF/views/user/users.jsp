<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원 목록</title>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous" />
<style>
@media ( min-width : 1200px) {
	.container {
		max-width: 970px;
	}
}
</style>
</head>
<body>
  <div class="container">
    <div class="py-5 text-center">
      <h2>회원 목록</h2>
    </div>

    <div class="row">
      <div class="col">
        <form class="row row-cols-lg-auto g-3 align-items-center">
          <div class="col-12">
            <select class="form-select" name="type">
              <option selected value="">전체목록</option>
              <option value="id">아이디</option>
              <option value="name">이름</option>
            </select>
          </div>
          <div class="col-12">
            <input type="text" class="form-control" name="value">
          </div>
          <div class="col-12">
            <button type="submit" class="btn btn-primary">검색</button>
          </div>
        </form>
      </div>
      <div class="col">
        <a href="/users/regist" class="btn btn-primary float-end">회원
          등록</a>
      </div>
    </div>

    <hr class="my-4">
    <div>
      <table class="table">
        <thead>
          <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일자</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${list}" var="user">
            <tr>
              <td><a href="/users/${user.id}">${user.id}</a></td>
              <td>${user.name}</td>
              <td><a href="mailto:${user.email}">${user.email}</a></td>
              <td>${user.regdate}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
</body>
</html>