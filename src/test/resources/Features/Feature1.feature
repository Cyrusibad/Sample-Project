Feature: Sample
  Scenario Outline: Feature with example
    Given This is a feature
    When <sample> is used
    Then it is ok
    Examples:
      | sample |