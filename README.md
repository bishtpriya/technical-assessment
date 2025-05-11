# technical-assessment
1) First Test Case to be automated under AppTest.java file .
Stable Internet Connection: The test execution environment has a reliable internet connection to access https://www.cloudbees.com/.

Consistent Website Structure: The structure and layout of the CloudBees website remain consistent over time, ensuring that elements like menus, links, and sections are identifiable by their selectors or text labels.

Element Identifiers: Web elements (e.g., links, buttons, text fields) have unique and consistent identifiers (such as IDs, classes, or link texts) that can be used to locate them during automation.

Browser Compatibility: The tests are executed on a browser version compatible with the CloudBees website, ensuring that all features render and function as expected.

No Authentication Required: All pages and resources to be tested are publicly accessible without the need for user authentication or special permissions.

Dynamic Content Loading: Any dynamic content (e.g., AJAX-loaded sections) loads within a reasonable time frame, and appropriate waits are implemented in the automation scripts to handle such scenarios.

Tab and Window Handling: Actions that open new tabs or windows (e.g., clicking on "Documentation" under "Resources") are handled appropriately in the automation framework, and the context is switched as needed to perform subsequent actions.

Search Functionality: The search feature on the CloudBees website returns results relevant to the input query (e.g., searching for "Installation") and displays pagination controls when multiple pages of results are available.

Scroll Behavior: The automation framework can programmatically scroll the webpage to bring elements into view before interacting with them, especially for elements not immediately visible upon page load.

Test Environment Isolation: The tests are executed in an isolated environment to prevent interference from other processes or browser extensions that might affect the outcome.


2)Second Test Case to be automated :- git under git.automation.java file .
Git is installed and accessible via the system's command line interface. The git command should be executable without requiring additional configuration.
The Java runtime environment has the necessary permissions to execute system-level commands using ProcessBuilder or Runtime.exec().
The target Git repository is accessible via HTTPS or SSH, and the system has the appropriate credentials or keys configured for authentication.
The user executing the automation script has write permissions to the repository, allowing for commits and pushes.
Inputs for file names and content are provided as valid, non-null strings. 
The repository is in a clean state, with no uncommitted changes or conflicts that could interfere with the automation process.
The automation operates on the default branch (commonly main or master). 
The repository has a remote named origin configured. If the remote is named differently or not set, the script may require adjustments.
The repository does not have Git hooks (e.g., pre-commit, pre-push) that could prevent commits or pushes.

Appended new content to this repo.
Appended new content to this repo.