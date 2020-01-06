<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
  <title>登录</title>
  <link rel="stylesheet" media="screen" href="css/login.css">
</head>

<body class="logged-out not-pro not-player not-self not-team not-on-team  grid-small grid-with-meta sign-in">
<div id="main-container">
  <section class="auth-sidebar">
    <div class="auth-sidebar-content">
      <header>
        <h1>登录会员，<br> 随时畅享优惠房价。
        </h1>
      </header>
      <div class="artwork">
        <div class="artwork-image"></div>
        <p class="artwork-attribution">
          图片来自
          <a class="url" rel="contact" href="https://unsplash.com/">Unsplash</a>
        </p>
      </div>
    </div>
  </section>
  <section class="content">
    <nav class="auth-nav">
      <p class="auth-link">
        尚未注册？ <a href="sign_up.jsp">点击这里注册</a>
      </p>
    </nav>
    <main>
      <div class="auth-content">
        <h2>登录会员账户</h2>
        <div class="auth-form sign-in-form">
          <form action="login.action" method="post">
            <div class="form-fields">
              <fieldset>
                <label for="phone">请输入您的手机号码</label>
                <input type="text" name="phone" id="phone" tabindex="1" class="text-input" autocomplete="off">
              </fieldset>

              <fieldset>
                <label for="password" class="password">请输入您的密码
                  <a href="#">忘记密码?</a></label>
                <input type="password" name="password" id="password" value="" tabindex="2" class="text-input">
              </fieldset>
            </div>

            <input class="button" type="submit" value="登录">
          </form>
          <p class="auth-link-mobile">
            尚未注册？ <a href="sign_up.jsp">点击这里注册</a>
          </p>
        </div>
      </div>
    </main>
  </section>
</div>

</body>

</html>
