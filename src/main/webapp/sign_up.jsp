<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>
  <title>
    注册会员
  </title>
  <link rel="stylesheet" media="screen" href="css/login.css"/>
</head>

<body class="logged-out not-pro not-player not-self not-team not-on-team  grid-small grid-with-meta sign-up">
<div id="main-container">
  <section class="auth-sidebar">
    <div class="auth-sidebar-content">
      <header>
        <h1>成为会员，<br> 随时畅享优惠房价。
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
        已经注册? <a href="/session/new">登录</a>
      </p>
    </nav>
    <main>
      <div class="auth-content">
        <h2>注册成为会员</h2>
        <div class="auth-form signup-form">
          <form class="hide-remove gen-form with-messages signup" id="new_user" action="*" accept-charset="UTF-8"
                method="post"><input name="utf8" type="hidden"/>

            <div class="form-field-group">
              <div class="form-field">
                <fieldset class="user_name"><label for="user_name">手机号码</label><input autocomplete="name"
                                                                                      class="text-input" type="text"
                                                                                      name="user[name]" id="user_name"/>
                </fieldset>
              </div>

              <div class="form-field">
                <fieldset class="user_login"><label for="user_login">用户名</label><input autocorrect="off"
                                                                                       autocapitalize="off"
                                                                                       autocomplete="username"
                                                                                       class="text-input" type="text"
                                                                                       name="user[login]"
                                                                                       id="user_login"/></fieldset>
              </div>
            </div>

            <div class="form-field">
              <fieldset class="user_email"><label for="user_email">电子邮箱</label><input class="text-input" type="text"
                                                                                      name="user[email]"
                                                                                      id="user_email"/></fieldset>
            </div>

            <div class="form-field">
              <fieldset class="user_password"><label for="user_password">密码</label><input class="text-input"
                                                                                          type="password"
                                                                                          name="user[password]" id="user_password"/>
              </fieldset>
            </div>

            <div class="form-field check-wrap opt-in">
              <fieldset>
                <input type="checkbox" id="user_agree_to_terms" name="user[agree_to_terms]"/>
                <label for="user_agree_to_terms">
                  注册账号证明您已知晓我司相关
                  <a target="_blank" href="/terms">用户细则</a>，
                  <a target="_blank" href="/privacy">隐私政策</a>。
                </label>
              </fieldset>
            </div>

            <div class="form-btns">
              <input type="submit" name="commit" value="创建账户" class="button" data-disable-with="Create Account"/>
            </div>

            <p class="auth-link-mobile">
              已经注册? <a href="/session/new">登录</a>
            </p>
          </form>
        </div>
      </div>

    </main>
  </section>
</div>

</body>

</html>