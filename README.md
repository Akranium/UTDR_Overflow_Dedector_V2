<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GPL-3.0 License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<h3 align="center">UTDR Overflow Dedector V2</h3>

  <p align="center">
    A cleaner rewritten verison of the original UTDR_Overflow_Dedector project with an added CLI
    <br />
    <a href="https://github.com/Akranium/UTDR_Overflow_Dedector_V2"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Akranium/UTDR_Overflow_Dedector_V2">View Demo</a>
    &middot;
    <a href="https://github.com/Akranium/UTDR_Overflow_Dedector_V2/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    &middot;
    <a href="https://github.com/Akranium/UTDR_Overflow_Dedector_V2/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project is created for the purposes of helping Undertale/Deltarune modders/translators write new dialogues in the game. The program reads the modified version of the JSON file and shows you the overflowing dialogues it detects.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Java][Java-logo]][Java-url]
* [![Intellij][Intellij-logo]][Intellij-url]
* ![No-ai-logo]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

You only need to download the latest verison of Java. Download from [this link](https://www.oracle.com/in/java/) if you don't have it already.

### Installation

1. Download the ZIP file of the latest version from [releases](https://github.com/Akranium/UTDR_Overflow_Dedector_V2/releases)
2. Unzip the package

### Running

To run the program, you have 2 options:

1. You can run the appropriate executable file located inside the program folder
2. You can nevigate to the program folder in the terminal and run:

   ```sh
   java --jar app.jar
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

To use the program:
1. Replace the dummy raw.json file located in the "raw" folder with the JSON file you want to read.
2. Rename your JSON file to "raw.json".
3. Run the program.

To see all the available commands, type "help".

Please note that first time you run the program, there will be a lot of false-positives and false-negatives. This is because there is no way of knowing for sure what the dimensions of dialogue box will be, and the program defaults to the standard dialogue with profile. You need to update the dimensions manually for other types of dialogues. Update a dialogue with the "update" command. 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Top contributors:

<a href="https://github.com/Akranium/UTDR_Overflow_Dedector_V2/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Akranium/UTDR_Overflow_Dedector_V2" alt="contrib.rocks image" />
</a>

<!-- LICENSE -->
## License

Distributed under the GPL-3.0 License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

E-Mail: akraniumemail132@gmail.com

Project Link: [https://github.com/Akranium/UTDR_Overflow_Dedector_V2](https://github.com/Akranium/UTDR_Overflow_Dedector_V2)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Akranium/UTDR_Overflow_Dedector_V2.svg?style=for-the-badge
[contributors-url]: https://github.com/Akranium/UTDR_Overflow_Dedector_V2/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Akranium/UTDR_Overflow_Dedector_V2.svg?style=for-the-badge
[forks-url]: https://github.com/Akranium/UTDR_Overflow_Dedector_V2/network/members
[stars-shield]: https://img.shields.io/github/stars/Akranium/UTDR_Overflow_Dedector_V2.svg?style=for-the-badge
[stars-url]: https://github.com/Akranium/UTDR_Overflow_Dedector_V2/stargazers
[issues-shield]: https://img.shields.io/github/issues/Akranium/UTDR_Overflow_Dedector_V2.svg?style=for-the-badge
[issues-url]: https://github.com/Akranium/UTDR_Overflow_Dedector_V2/issues
[license-shield]: https://img.shields.io/github/license/Akranium/UTDR_Overflow_Dedector_V2.svg?style=for-the-badge
[license-url]: https://github.com/Akranium/UTDR_Overflow_Dedector_V2/blob/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/mustafa-emre-olmez
[product-screenshot]: images/screenshot.png
<!-- Shields.io badges. You can a comprehensive list with many more badges at: https://github.com/inttter/md-badges -->
[Java-logo]: https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/
[No-ai-logo]: https://custom-icon-badges.demolab.com/badge/No%20AI-2f2f2f?logo=non-ai&logoColor=white
[Intellij-logo]: https://img.shields.io/badge/IntelliJIDEA-000000.svg?logo=intellij-idea&logoColor=white
[Intellij-url]: https://www.jetbrains.com/idea/


## An Important Note

== We're Using GitHub Under Protest ==

This project is currently hosted on GitHub.  This is not ideal; GitHub is a
proprietary, trade-secret system that is not Free and Open Souce Software
(FOSS).  We are deeply concerned about using a proprietary system like GitHub
to develop our FOSS project. We urge you to read about the
[Give up GitHub](https://GiveUpGitHub.org) campaign from
[the Software Freedom Conservancy](https://sfconservancy.org) to understand
some of the reasons why GitHub is not a good place to host FOSS projects.

If you are a contributor who personally has already quit using GitHub, please
[check this resource](INSERT_LINK) for how to send us contributions without
using GitHub directly.

Any use of this project's code by GitHub Copilot, past or present, is done
without our permission.  We do not consent to GitHub's use of this project's
code in Copilot.

![Logo of the GiveUpGitHub campaign](https://sfconservancy.org/static/img/GiveUpGitHub.png)
