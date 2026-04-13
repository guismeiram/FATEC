using Aula_07_Identity.Models;
using Aula_07_Identity.Models.Identity;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using System.Data;

namespace Aula_07_Identity.Controllers
{
    public class AuthController : Controller
    {
        private readonly UserManager<AppUser> UserManager;
        private readonly SignInManager<AppUser> SignInManager;
        private readonly RoleManager<IdentityRole> RoleManager;

        public AuthController(UserManager<AppUser> userManager,
            SignInManager<AppUser> signInManager,
            RoleManager<IdentityRole> roleManager)
        {
            UserManager = userManager;
            SignInManager = signInManager;
            RoleManager = roleManager;
        }

        [AllowAnonymous]
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [AllowAnonymous]
        public async Task<IActionResult> Login(LoginViewModel loginViewModel)
        {
            if (!ModelState.IsValid)
            {
                return View(loginViewModel);
            }

            var result = await SignInManager.PasswordSignInAsync(
                loginViewModel.Email,
                loginViewModel.Password,
                loginViewModel.Remember,
                false
            );

            if (!result.Succeeded)
            {
                ModelState.AddModelError(string.Empty, "Usuário ou senha inválidos.");
                return View(loginViewModel);
            }

            return RedirectToAction("Index", "Home");
        }

        [Authorize]
        public async Task<IActionResult> Logout()
        {
            await SignInManager.SignOutAsync();
            return RedirectToAction("Login", "Auth");
        }

        private void SelectListRoles()
        {
            var roles = RoleManager.Roles.Select(x => new { x.Id, x.Name });
            ViewData["Role"] = new SelectList(roles, "Id", "Name");
        }

        [HttpGet]
        [AllowAnonymous]
        public IActionResult Register()
        {
            return View();
        }

        [HttpPost]
        [AllowAnonymous]
        public async Task<IActionResult> Register(AuthUserViewModel authUserViewModel)
        {
            if (!ModelState.IsValid)
            {
                return View(authUserViewModel);
            }

            var user = new AppUser
            {
                UserName = authUserViewModel.UserName,
                Email = authUserViewModel.UserName
            };

            var result = await UserManager.CreateAsync(user, authUserViewModel.Password);

            if (!result.Succeeded)
            {
                foreach (var error in result.Errors)
                {
                    ModelState.AddModelError(string.Empty, error.Description);
                }

                return View(authUserViewModel);
            }

            TempData["SuccessMessage"] = "Usuário cadastrado com sucesso! Faça login para continuar.";

            return RedirectToAction("Login", "Auth");
        }
    }

}
