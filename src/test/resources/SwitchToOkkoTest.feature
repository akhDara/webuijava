Feature: Переход на страницу Окко

  Background:
    Given Пользователь на главной странице

  @hooks
     @close
  Scenario:
    When навести На Кино
    Then Проверяем переход на страницу Окко
