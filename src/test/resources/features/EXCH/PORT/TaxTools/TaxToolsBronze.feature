@TAXTOOLS
Feature:Tax Tool: - Bronze - Verifying the correct amount is displayed

  @SLER-2214
  Scenario Outline:Bronze - Verifying the correct amount is displayed for one member

    Given I open the login page on the "tax Bronze" portal
    When I validate I am on the "tax Bronze" page
    Then I enter for one member "<zipCode>" and "<county>" "<age>" and validate the cost of Branze Plan "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county    | age | ExpectedPremium | ExpectedProvider                | ExpectedPlan                                               |
      | 80202   | DENVER    | 56  | $541.31         | Denver Health Medical Plan      | Elevate Health Plans Bronze HDHP                           |
      | 80203   | Denver    | 32  | $274.48         | Denver Health Medical Plan      | Elevate Health Plans Bronze HDHP                           |
      | 80134   | Douglas   | 67  | $736.28         | Kaiser Permanente               | KP Select CO Bronze 8500/50                                |
      | 80134   | Elbert    | 31  | $284.45         | Kaiser Permanente               | KP Select CO Bronze 8500/50                                |
      | 80002   | Adams     | 55  | $517.41         | Denver Health Medical Plan      | Elevate Health Plans Bronze HDHP                           |
      | 80002   | Jefferson | 55  | $517.41         | Denver Health Medical Plan      | Elevate Health Plans Bronze HDHP                           |
      | 81658   | Eagle     | 43  | $436.60         | Anthem Blue Cross & Blue Shield | Anthem Bronze Mountain Enhanced X HMO 9450 $0 Select Drugs |
      | 81427   | Ouray     | 32  | $383.52         | Rocky Mountain Health Plans     | RMHP Valley Colorado Option Bronze                         |
      | 81230   | Gunnison  | 45  | $468.13         | Rocky Mountain Health Plans     | RMHP Valley Colorado Option Bronze                         |
      | 81064   | Baca      | 74  | $960.39         | Anthem Blue Cross & Blue Shield | Anthem Bronze Pathway X HMO 9450 $0 Select Drugs           |
      | 81143   | Saguache  | 63  | $945.02         | Anthem Blue Cross & Blue Shield | Anthem Bronze Pathway X HMO 9450 $0 Select Drugs           |
#      Bug
#      | 81301   | La Plata  | 23  | $302.88         | Denver Health Medical Plan      | Elevate Health Plans Bronze HDHP                           |
#     | 81325   | Dolores   | 32  | $358.30         | Denver Health Medical Plan      | Elevate Health Plans Bronze HDHP                           |
      | 81623   | Gunnison  | 83  | $972.57         | Rocky Mountain Health Plans     | RMHP Valley Colorado Option Bronze                         |
      | 80480   | Jackson   | 51  | $749.82         | Anthem Blue Cross & Blue Shield | Anthem Bronze Pathway X HMO 9450 $0 Select Drugs           |
      | 81653   | Moffat    | 88  | $882.09         | Rocky Mountain Health Plans     | RMHP Monument One Colorado Option Bronze                   |
      | 81633   | Moffat    | 34  | $356.95         | Rocky Mountain Health Plans     | RMHP Monument One Colorado Option Bronze                   |
      | 80534   | Larimar   | 22  | $272.71         | Cigna                           | Cigna Connect Colorado Option Bronze                       |
      | 80754   | Weld      | 55  | $576.22         | Cigna                           | Cigna Connect Colorado Option Bronze                       |
      | 80624   | Weld      | 67  | $775.17         | Cigna                           | Cigna Connect Colorado Option Bronze                       |









