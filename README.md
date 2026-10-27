# UITAP Automation

A dual-stack UI test automation portfolio for [uitestingplayground.com](http://uitestingplayground.com), built to demonstrate the same 22 testing scenarios solved two different ways: **Python + Playwright** and **Java + Selenium**. Both stacks run UI and BDD tests, report through Allure, and deploy automatically via CI.

[![Python Playwright Tests](https://github.com/IF22I/uitap-automation/actions/workflows/python-playwright.yml/badge.svg)](https://github.com/IF22I/uitap-automation/actions/workflows/python-playwright.yml)
[![Python API Tests](https://github.com/IF22I/uitap-automation/actions/workflows/python-api.yml/badge.svg)](https://github.com/IF22I/uitap-automation/actions/workflows/python-api.yml)
[![Java Selenium Tests](https://github.com/IF22I/uitap-automation/actions/workflows/java-selenium.yml/badge.svg)](https://github.com/IF22I/uitap-automation/actions/workflows/java-selenium.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**📊 Live Allure reports:** https://if22i.github.io/uitap-automation/

## Why two stacks

Testing the same scenarios in two languages and two frameworks forces an honest comparison: where Playwright's auto-waiting removes boilerplate Selenium needs explicit `WebDriverWait` for, where TestNG's XML suite configuration differs from pytest markers, how BDD (Cucumber vs Behave) changes the shape of a test. It's also just more representative of real teams, where you rarely get to pick one tool forever.

## Tech stack

| | Python | Java |
|---|---|---|
| Browser automation | Playwright | Selenium 4 |
| Test runner | pytest | TestNG |
| BDD | Behave | Cucumber |
| Reporting | Allure | Allure |
| Build/deps | `requirements.txt` (pinned) | Maven |

## CI/CD

Both stacks run on GitHub Actions (`.github/workflows/python-playwright.yml`, `.github/workflows/java-selenium.yml`):

- **On every push** to any branch, and **nightly at 02:00 UTC** (full regression).
- **Manually** via `workflow_dispatch`, with dropdowns for browser (chromium/firefox/webkit for Python, chrome/firefox for Java) and test group (`smoke` or `regression`).
- On `main`, both pipelines generate an Allure report and publish it to GitHub Pages, including Python's historical trend graph, which survives every deploy by pulling its own last published history before regenerating.
- Since two independent workflows publish to one Pages site, a small shared storage branch (`gh-pages-src`) keeps each language's report in its own subfolder so neither deploy overwrites the other.

## Architecture & patterns (Java side)

- **Page Object Model**: `pages/` wraps each page's elements and actions; tests never touch Selenium locators directly.
- **Factory** (`DriverFactory`): one static method builds the right `WebDriver` for the requested browser and headless mode.
- **Singleton** (`DriverManager`): holds exactly one driver instance per test run, exposed via `getDriver()`, torn down via `quitDriver()`.
- **Hooks** (`stepdefinitions/Hooks.java`): Cucumber's `@Before`/`@After` lifecycle wires the Singleton driver into each BDD scenario.

## How to run locally

### Python (Playwright)
```bash
cd python-playwright
python -m venv .venv
.venv\Scripts\activate          # Windows; use "source .venv/bin/activate" on macOS/Linux
pip install -r requirements.txt
playwright install

pytest -m smoke                 # smoke suite
pytest -m regression            # full regression
behave features/                # BDD scenarios

allure serve allure-results     # view the report locally (needs Node.js + `npm install -g allure-commandline`)
```

### Java (Selenium)
```bash
cd java-selenium
mvn test                                        # full TestNG suite (testng.xml)
mvn test -Dtest=TestRunner                      # Cucumber BDD scenarios
mvn test -Dgroups=smoke -Dbrowser=chrome        # smoke only, explicit browser

allure open allure-report                       # after generating with `allure generate allure-results -o allure-report`
```

## What I learned

A few things from building and maintaining this repo that don't show up in a green checkmark:

- **A flaky test is a symptom, not a verdict.** `ProgressBarTest` failed intermittently for weeks before I isolated the cause: the progress bar's animation speed is randomized per page load (1.4s to 25s observed), and the default 500ms `WebDriverWait` polling interval let fast bars blow straight past the target percentage. Fixed by moving both detection and the stop-click into the browser via `executeAsyncScript` and `requestAnimationFrame`, eliminating the WebDriver round-trip entirely. Verified with 40 consecutive runs at a tightened tolerance before trusting it.
- **"It passed" and "it did what I intended" are different claims.** A code review of an already-green Cucumber run caught a real bug: the `browser` system property was being read but never actually passed to the driver factory, every CI run was silently using the hardcoded default.
- **Headless isn't one thing.** `ShadowDomTest`'s clipboard check was guarded against the wrong kind of "headless", JVM headless (`GraphicsEnvironment.isHeadless()`) instead of the browser's own headless flag, two genuinely different conditions that happened to usually agree, until they didn't.
- **Not every test works in every browser.** Chromium exposes clipboard permissions Playwright can grant; Firefox doesn't. `test_22_shadowdom.py` now skips cleanly on non-Chromium browsers instead of failing with a confusing permissions error.

## License

MIT, see [LICENSE](LICENSE).