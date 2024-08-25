console.log("Hellow Script Loaded");
let currentTheme=getTheme();
const changeThemeButton=document.querySelector('#theme_change_button');
changeThemeButton.querySelector("span").textContent=currentTheme=="light"?" Dark ":" Light ";
function getTheme()
{
    const theme=localStorage.getItem("theme");
    return theme?theme:"light";
}
document.querySelector("html").classList.add(currentTheme);

changeTheme();

function changeTheme()
{
    changeThemeButton.addEventListener('click',(event)=>
    {
        localStorage.setItem("theme",currentTheme);
        const oldTheme=currentTheme
        currentTheme=currentTheme=="dark"?"light":"dark";
        localStorage.setItem("theme",currentTheme);
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);
        changeThemeButton.querySelector("span").textContent=currentTheme=="light"?" Dark ":" Light ";
    });
}

