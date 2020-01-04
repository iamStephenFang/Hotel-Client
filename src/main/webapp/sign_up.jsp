<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>
  <title>注册会员</title>
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
        已经注册? <a href="sign_in.jsp">登录</a>
      </p>
    </nav>
    <main>
      <div class="auth-content">
        <h2>注册成为会员</h2>
        <div class="auth-form signup-form">
          <form class="hide-remove gen-form with-messages signup" id="new_user" action="insertRegister.action" accept-charset="UTF-8"
                method="post"><input name="utf8" type="hidden"/>

            <div class="form-field-group">
              <div class="form-field">
                <fieldset class="user_name"><label for="register.phone">手机号码</label><input autocomplete="name"
                                                                                      class="text-input" type="text"
                                                                                      name="register.phone" id="register.phone"/>
                </fieldset>
              </div>

              <div class="form-field">
                <fieldset class="user_login"><label for="register.account">用户名</label><input autocorrect="off"
                                                                                       autocapitalize="off"
                                                                                       autocomplete="username"
                                                                                       class="text-input" type="text"
                                                                                       name="register.account"
                                                                                       id="register.account"/></fieldset>
              </div>
            </div>

            <div class="form-field">
              <fieldset class="user_gender"><label>性别</label>
                <select name="register.gender" style="width: 100%;-webkit-box-sizing: border-box;box-sizing: border-box;border: none;border-radius: 6px;padding: 9px 15px;margin-right: 8px; background: #f5f6f7; color: #444; -webkit-box-shadow: inset 0px 2px 3px rgba(0, 0, 0, 0.03); box-shadow: inset 0px 2px 3px rgba(0, 0, 0, 0.03); outline: none;height:40px;font-size: 16px">
                  <option value="true">先生</option>
                  <option value="false">女士</option>
                </select>
              </fieldset>
            </div>

            <div class="form-field">
              <fieldset class="user_email"><label for="register.email">电子邮箱</label><input class="text-input" type="text"
                                                                                      name="register.email"
                                                                                      id="register.email"/></fieldset>
            </div>

            <div class="form-field">
              <fieldset class="password"><label for="register.password">密码</label><input class="text-input"
                                                                                          type="password"
                                                                                          name="register.password"
                                                                                          id="register.password"/>
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
              已经注册? <a href="sign_in.jsp">登录</a>
            </p>
          </form>
        </div>
      </div>

    </main>
  </section>
</div>

</body>

</html>