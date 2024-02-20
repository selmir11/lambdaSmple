# Pull Request

## PR Checklist: (Please check on the PR in GitHub and then mark the below)
- [ ] Do you see all the changes to be reviewed in this PR on GitHub?
- [ ] Does the scenario have the tag added with new test case number?
- [ ] Added both old and new test case jira links in the description
- [ ] Strictly limit one scenario addition or update at a time
- [ ] Does the scenario tag include WIP if it is incomplete?
- [ ] Application.properties file should not have any changes
- [ ] Should not have implicit waits
- [ ] Locators should use ID whenever available. Second options would be css or xpath.
 {{ Should not have any complex xpaths or complex css. Should keep it as simple as possible }}
- [ ] If we have list of webElements, instead of writing 5-6 locators for each of them, Should prioritize using List Webelement.
- [ ] Did the test run successfully even if it is WIP ?
- [ ] File names should not have the test case number
- [ ] File names and Feature name should have a general description that will cover all the scenarios in the feature file
- [ ] Scenario description has to be very specific to what is being covered in that scenario.
- [ ] If you update an existing scenario, step definition or method that is already being used or any alternate better step for an existing one, you should check all the scenarios that are relying on them and should be passing successfully. Clean up should be done properly so we do not have multiple steps or functions doing the same thing in the codebase.

### Failing to adhere to above checklist will cause delays in getting the PR merged.
