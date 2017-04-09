Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation successful with correct username and password
    Given new user is selected
    When username "donaldo" and password "fake_news" and password confirmation "fake_news" are given
    Then user is registered

  Scenario: creation fails with too short username and valid password
    Given new user is selected
    When username "aa" and password "fake_news" and password confirmation "fake_news" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When username "donaldo" and password "f00" and password confirmation "f00" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When username "donaldo" and password "fakenews" and password confirmation "fakenews" are given
    Then user is not created and error "password cannot contain only letters" is reported

  Scenario: creation fails with already taken username and valid password
    Given new user is selected
    When username "jukka" and password "fake_news" and password confirmation "fake_news" are given
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When username "donaldo" and password "fake_news" and password confirmation "plapla222" are given
    Then user is not created and error "password and password confirmation do not match" is reported

  Scenario: user can login with successfully generated account
    Given user with username "liisa" with password "salainen1" is successfully created
    And login is selected
    When correct username "liisa" and password "salainen1" are given
    Then user is logged in

  Scenario: user cannot login with account that is not successfully created
    Given user with username "aa" with password "bad" is unsuccessfully created
    And login is selected
    When nonexistent username "aa" and password "bad" are given
    Then user is not logged in and error message is given
